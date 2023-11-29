package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.dto.Reservation.ReservationDto;
import com.example.backendengineeringwork.dto.Reservation.ReservationViewDto;
import com.example.backendengineeringwork.services.ReservationService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@NoArgsConstructor
@RequestMapping("/api/v1/reservations")
public class ReservationController{

    ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAll() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDto> getById(@PathVariable Long id) {
        ReservationDto reservationDto = reservationService.findById(id);
        if(reservationDto != null){
            return ResponseEntity.ok().body(reservationDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ReservationDto> create(@RequestBody ReservationDto entity) {
        return ResponseEntity.ok(reservationService.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationDto> update(@PathVariable Long id, @RequestBody ReservationDto updatedEntity) {
        if (reservationService.findById(id) != null) {
            return ResponseEntity.ok().body(reservationService.save(updatedEntity));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (reservationService.findById(id) != null) {
            reservationService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/car/{car_id}")
    public ResponseEntity<List<ReservationDto>> getReservationByCarId(@PathVariable Long carId){
        List<ReservationDto> reservations = reservationService.getReservationByCarId(carId);
        return ResponseEntity.ok().body(reservations);
    }

    @GetMapping("/person/{user_id}")
    public ResponseEntity<List<ReservationDto>> getReservationByUserId(@PathVariable Long userId){
        List<ReservationDto> reservations = reservationService.getReservationByUserId(userId);
        return ResponseEntity.ok().body(reservations);
    }

    @PostMapping("/getByEmail")
    public ResponseEntity<List<ReservationViewDto>> getReservationByEmail(@RequestBody String email){
        List<ReservationViewDto> reservations = reservationService.getReservationByUserEmail(email);
        return ResponseEntity.ok().body(reservations);
    }
}
