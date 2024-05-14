package com.example.backendengineeringwork.security.auth;


import com.example.backendengineeringwork.commands.user.RegisterUserCommand;
import com.example.backendengineeringwork.security.dtos.AuthenticationRequest;
import com.example.backendengineeringwork.security.dtos.AuthenticationResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/security")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public AuthenticationResponse register(
            @RequestBody RegisterUserCommand request
    ) {
       return service.register(request);
    }
    @PostMapping("/login")
    public AuthenticationResponse authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return service.authenticate(request);
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response ){
        service.refreshToken(request, response);
    }
}

