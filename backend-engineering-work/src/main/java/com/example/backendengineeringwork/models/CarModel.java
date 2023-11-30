package com.example.backendengineeringwork.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;
import javax.validation.constraints.*;

import java.util.UUID;

@Entity
@Data
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @NotBlank
    private String type;

    @NotNull
    @Min(1)
    private Integer seats;

    @NotBlank
    private String drive;

    @NotBlank
    private String transmission;

    @NotNull
    private Integer topSpeed;

    @NotNull
    private Double acceleration;

    @NotNull
    @DecimalMin(value = "0")
    private Double fuelConsumption;
}
