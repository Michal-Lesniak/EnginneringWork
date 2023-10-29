package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.models.Reservation;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController extends AbstractController<Reservation, Long>{
    @GetMapping("/car/{car_id}") //TODO reservationByCarId
    public ResponseEntity<List<Reservation>> getReservationByCarId(@PathVariable Long carId){
        return null;
    }

    @GetMapping("/person/{user_id}") //TODO reservationByUserId
    public ResponseEntity<List<Reservation>> getReservationByUserId(@PathVariable Long userId){
        return null;
    }
}
