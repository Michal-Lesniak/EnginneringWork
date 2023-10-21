package com.example.backendengineeringwork.dto;

import lombok.Data;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
public class ReservationDto {

    private Long id;

    @NotNull
    private Long carId;

    @NotNull
    private LocalDateTime rentDate;

    @NotNull
    private LocalDateTime arrivalDate;

    @NotNull
    private Long personId;

    @NotBlank
    private String rentCity;

    @NotBlank
    private String arrivalCity;
}