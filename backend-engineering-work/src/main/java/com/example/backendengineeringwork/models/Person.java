package com.example.backendengineeringwork.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotNull
    @Past
    private LocalDate bornDate;

    @Pattern(regexp = "^\\+[0-9]{1,3}\\.[0-9]{4,14}(?:x.+)?$")
    private String mobilePhone;

    @Email
    private String email;

    @NotBlank
    private String city;

    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$")
    private String postCode;

    @NotBlank
    private String address;
}
