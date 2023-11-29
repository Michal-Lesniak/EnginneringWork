package com.example.backendengineeringwork.dto.Reservation;

import java.time.LocalDateTime;

public record ReservationDto(
                Long id,
                Long carId,
                Long userId,
                Long rentCityId,
                Long arrivalCityId,
                LocalDateTime rentDate,
                LocalDateTime arrivalDate) {}
