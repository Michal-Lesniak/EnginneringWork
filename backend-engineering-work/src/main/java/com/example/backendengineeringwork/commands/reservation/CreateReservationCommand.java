package com.example.backendengineeringwork.commands.reservation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class CreateReservationCommand {
    private long carId;
    private long userId;
    private long rentCityId;
    private long arrivalCityId;
    private LocalDateTime rentDate;
    private LocalDateTime arrivalDate;
}
