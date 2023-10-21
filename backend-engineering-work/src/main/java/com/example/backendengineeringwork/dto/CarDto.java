package com.example.backendengineeringwork.dto;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class CarDto {

    private Long id;

    @NotBlank
    private String brand;

    @NotNull
    private Long modelId;

    @NotNull
    @PastOrPresent
    private Integer productionYear;
}
