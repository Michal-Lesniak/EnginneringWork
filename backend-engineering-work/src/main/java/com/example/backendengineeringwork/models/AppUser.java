package com.example.backendengineeringwork.models;

import jakarta.persistence.*;
import lombok.*;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @NotBlank
    private String login;

    @NotBlank
    @Size(min = 6)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
