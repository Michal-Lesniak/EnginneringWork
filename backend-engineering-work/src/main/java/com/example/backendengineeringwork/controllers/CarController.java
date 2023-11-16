package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.models.Car;
import com.example.backendengineeringwork.services.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController extends AbstractController<Car, Long> {

    public CarController(CarService service){
        super(service);
    }
}
