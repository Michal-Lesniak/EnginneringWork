package com.example.backendengineeringwork.dto;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class CarModelDto {

    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private Long engineId;

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
    @DecimalMin(value = "0")
    private Double fuelConsumption;
}