package com.example.backendengineeringwork.security.auth;


import com.example.backendengineeringwork.commands.user.RegisterUserCommand;
import com.example.backendengineeringwork.models.Person;
import com.example.backendengineeringwork.security.JwtService;
import com.example.backendengineeringwork.security.dtos.AuthenticationRequest;
import com.example.backendengineeringwork.security.dtos.AuthenticationResponse;
import com.example.backendengineeringwork.security.token.Token;
import com.example.backendengineeringwork.security.token.TokenRepository;
import com.example.backendengineeringwork.security.token.TokenType;
import com.example.backendengineeringwork.models.User;
import com.example.backendengineeringwork.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterUserCommand request) {
        var user = User.builder()
                .person(Person.builder()
                        .name(request.getFirstname())
                        .surname(request.getLastname())
                        .bornDate(request.getBornDate())
                        .city(request.getCity())
                        .postCode(request.getPostCode())
                        .address(request.getAddress())
                        .build())
                .mobilePhone(request.getMobilePhone())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", Arrays.stream(user.getAuthorities().toArray()).map(Objects::toString).toList());
        claims.put("userId", user.getId());
        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(claims, user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", Arrays.stream(user.getAuthorities().toArray()).map(Objects::toString).toList());
        claims.put("userId", user.getId());
        var jwtToken = jwtService.generateToken(claims, user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                Map<String, Object> claims = new HashMap<>();
                claims.put("roles", Arrays.stream(user.getAuthorities().toArray()).map(Objects::toString).toList());
                claims.put("userId", user.getId());
                var accessToken = jwtService.generateToken(claims, user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                try {
                    new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}