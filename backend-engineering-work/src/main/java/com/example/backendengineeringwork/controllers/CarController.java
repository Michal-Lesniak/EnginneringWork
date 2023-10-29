package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.models.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class CarController extends AbstractController<Car, Long> {
    //TODO cennik na backendzie (1-3 dni, 3 - 7, powyżej 7, powyzej 21
    //TODO dodawnie zdjęć, zapis na serwerze ;D ??? Zapis zdjęć, usunięcie zdjęcia
}
