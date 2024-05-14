package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.commands.reservation.CreateReservationCommand;
import com.example.backendengineeringwork.dtos.reservation.ReservationDto;
import com.example.backendengineeringwork.dtos.reservation.ReservationViewDto;
import com.example.backendengineeringwork.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reservations")
public class ReservationController{

    ReservationService reservationService;

    @GetMapping
    public List<ReservationDto> getAll() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public ReservationDto getById(@PathVariable long id) {
       return reservationService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationDto create(@RequestBody CreateReservationCommand command) {
           return reservationService.save(command);
    }

    @PutMapping("/{id}")
    public ReservationDto update(@PathVariable long id, @RequestBody CreateReservationCommand command) {
           return reservationService.update(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        reservationService.deleteById(id);
    }

    @GetMapping("/car/{carId}")
    public List<ReservationDto> getReservationByCarId(@PathVariable long carId){
        return reservationService.getReservationByCarId(carId);
    }

    @GetMapping("/person/{userId}")
    public List<ReservationDto> getReservationByUserId(@PathVariable long userId){
        return reservationService.getReservationByUserId(userId);
    }

    @PostMapping("/getByEmail")
    public List<ReservationViewDto> getReservationByEmail(@RequestBody String email){
        return reservationService.getReservationByUserEmail(email);
    }
}
