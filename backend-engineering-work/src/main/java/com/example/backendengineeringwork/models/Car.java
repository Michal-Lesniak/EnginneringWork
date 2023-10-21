package com.example.backendengineeringwork.models;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.UUID;

@Entity
@Data
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String brand;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private CarModel model;

    @NotNull
    @PastOrPresent
    private Integer productionYear;
}
