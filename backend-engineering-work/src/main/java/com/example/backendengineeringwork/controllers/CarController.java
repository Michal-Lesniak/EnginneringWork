package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.models.Car;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class CarController extends AbstractController<Car, Long>{
    //TODO create car controllers to add/delete car only for Admin
    //TODO back reservation datas
}
