package com.example.backendengineeringwork.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String login;
    private String password;
}
