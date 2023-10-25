package com.example.backendengineeringwork.models;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @NotNull
    private LocalDateTime rentDate;

    @NotNull
    private LocalDateTime arrivalDate;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private AppUser user;

    @NotBlank
    private String rentCity;

    @NotBlank
    private String arrivalCity;
}
