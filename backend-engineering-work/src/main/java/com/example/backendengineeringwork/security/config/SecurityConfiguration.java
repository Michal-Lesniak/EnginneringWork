package com.example.backendengineeringwork.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.example.backendengineeringwork.security.user.Role.ADMIN;
import static com.example.backendengineeringwork.security.user.Role.USER;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {
    private static final AntPathRequestMatcher[] WHITE_LIST_URL = {
            new AntPathRequestMatcher("/api/v1/security/**"),
            new AntPathRequestMatcher("/api/v1/auth/**"),
            new AntPathRequestMatcher("/api/v1/cars/**", GET.name()),
            new AntPathRequestMatcher("/api/v1/cars/list/**", GET.name()),
            new AntPathRequestMatcher("/api/v1/reservation/car/**", GET.name()),
            new AntPathRequestMatcher("/swagger-ui/**"),
            new AntPathRequestMatcher("/swagger-resources/**"),
            new AntPathRequestMatcher("/swagger-resources"),
            new AntPathRequestMatcher("/swagger-ui.html"),
            new AntPathRequestMatcher("/v2/api-docs"),
            new AntPathRequestMatcher("/v3/api-docs"),
            new AntPathRequestMatcher("/v3/api-docs/**")
    };
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf((AbstractHttpConfigurer::disable))
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(req -> req
                        .requestMatchers(WHITE_LIST_URL)
                        .permitAll()
                        .requestMatchers("/api/v1/cars/**").hasRole(ADMIN.name())
                        .requestMatchers("/api/v1/users/getByEmail").hasAnyRole(ADMIN.name(), USER.name())
                        .requestMatchers(PUT, "/api/v1/users/**").hasAnyRole(ADMIN.name(), USER.name())
                        .requestMatchers("/api/v1/users/**").hasRole(ADMIN.name())
                        .requestMatchers(GET,"/api/v1/cities/**").hasAnyRole(ADMIN.name(), USER.name())
                        .requestMatchers("/api/v1/cities/**").hasRole(ADMIN.name())
                        .requestMatchers("/api/v1/images/**").hasRole(ADMIN.name())
                        .requestMatchers("/api/v1/persons/**").hasAnyRole(ADMIN.name(), USER.name())
                        .requestMatchers(POST,"/api/v1/reservations/**").hasAnyRole(ADMIN.name(), USER.name())
                        .requestMatchers("/api/v1/reservations/**").hasRole(ADMIN.name())
                        .requestMatchers("/api/v1/reservations/getbyEmail").hasAnyRole(ADMIN.name(), USER.name())
                        .anyRequest()
                        .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout ->
                        logout
                                .logoutUrl("/api/v1/auth/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                )
        ;

        return http.build();
    }
}