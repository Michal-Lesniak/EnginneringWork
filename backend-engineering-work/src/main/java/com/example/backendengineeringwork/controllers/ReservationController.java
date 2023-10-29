package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.models.Reservation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController extends AbstractController<Reservation, Long>{
    //TODO make, change, delete reservation only for logging user
}
