package com.example.backendengineeringwork.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DecimalMin(value = "0.5")
    private Double engineCapacity;

    @NotNull
    private Integer power;

    @NotNull
    private Integer torque;

    @NotBlank
    private String fuel;
}
