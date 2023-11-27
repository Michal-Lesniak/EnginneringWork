package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.models.Reservation;
import com.example.backendengineeringwork.services.ReservationService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController extends AbstractController<Reservation, Long>{


    private final ReservationService reservationService;

    public  ReservationController(ReservationService service) {
        super(service);
        this.reservationService = service;
    }


    @GetMapping("/car/{car_id}")
    public ResponseEntity<List<Reservation>> getReservationByCarId(@PathVariable Long carId){
        List<Reservation> reservations = reservationService.getReservationByCarId(carId);
        return ResponseEntity.ok().body(reservations);
    }

    @GetMapping("/person/{user_id}")
    public ResponseEntity<List<Reservation>> getReservationByUserId(@PathVariable Long userId){
        List<Reservation> reservations = reservationService.getReservationByUserId(userId);
        return ResponseEntity.ok().body(reservations);
    }

    @PostMapping("/getByEmail")
    public ResponseEntity<List<Reservation>> getReservationByEmail(@RequestBody String email){
        List<Reservation> reservations = reservationService.getReservationByUserEmail(email);
        return ResponseEntity.ok().body(reservations);
    }
}
