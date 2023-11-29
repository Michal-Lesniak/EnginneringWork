package com.example.backendengineeringwork.security.user.dto;

import com.example.backendengineeringwork.dto.Reservation.ReservationViewDto;
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
