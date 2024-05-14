package com.example.backendengineeringwork.dtos.user;

import com.example.backendengineeringwork.dtos.reservation.ReservationViewDto;
import com.example.backendengineeringwork.models.Person;

import java.util.List;

public record UserProfileDto(
        Long id,
        Person person,
        String mobilePhone,
        String email,
        List<ReservationViewDto> reservationViewList
) {
}
