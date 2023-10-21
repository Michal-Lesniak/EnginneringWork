package com.example.backendengineeringwork.dto;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class EngineDto {

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
