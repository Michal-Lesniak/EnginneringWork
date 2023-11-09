package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.models.Reservation;
import com.example.backendengineeringwork.services.ReservationService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        if(reservations.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/person/{user_id}")
    public ResponseEntity<List<Reservation>> getReservationByUserId(@PathVariable Long userId){
        List<Reservation> reservations = reservationService.getReservationByUserId(userId);
        if(reservations.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservations);
    }
}
