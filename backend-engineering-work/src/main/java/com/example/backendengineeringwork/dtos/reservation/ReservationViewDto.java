package com.example.backendengineeringwork.dtos.reservation;

import java.time.LocalDateTime;

public record ReservationViewDto(
        String carName,
        String rentCity,
        String arrivalCity,
        LocalDateTime rentDate,
        LocalDateTime arrivalDate,
        Long costOfRent
) {
}
