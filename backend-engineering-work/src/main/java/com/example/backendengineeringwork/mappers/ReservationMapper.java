package com.example.backendengineeringwork.mappers;

import com.example.backendengineeringwork.commands.reservation.CreateReservationCommand;
import com.example.backendengineeringwork.dtos.reservation.ReservationDto;
import com.example.backendengineeringwork.dtos.reservation.ReservationViewDto;
import com.example.backendengineeringwork.models.Reservation;

import java.time.Duration;

public class ReservationMapper {
    public static ReservationDto toDto(Reservation reservation){
        return new ReservationDto(
                reservation.getId(),
                reservation.getCar().getId(),
                reservation.getUser().getId(),
                reservation.getRentCity().getId(),
                reservation.getArrivalCity().getId(),
                reservation.getRentDate(),
                reservation.getArrivalDate()
        );
    }

    public static ReservationViewDto toViewDto(Reservation reservation){
        Long costOfRent = reservation.getCar().getRentPrizePerDay() * Duration.between(reservation.getRentDate(), reservation.getArrivalDate()).toDays();
        return new ReservationViewDto(
                reservation.getCar().getBrand() + " " + reservation.getCar().getModel().getName(),
                reservation.getRentCity().getName(),
                reservation.getArrivalCity().getName(),
                reservation.getRentDate(),
                reservation.getArrivalDate(),
                costOfRent
        );
    }

}
