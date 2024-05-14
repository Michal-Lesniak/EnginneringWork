package com.example.backendengineeringwork.commands.user;

import com.example.backendengineeringwork.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserCommand {

    private String firstname;
    private String lastname;
    private LocalDate bornDate;
    private String mobilePhone;
    private String city;
    private String postCode;
    private String address;
    private String email;
    private String password;
    private Role role;
}