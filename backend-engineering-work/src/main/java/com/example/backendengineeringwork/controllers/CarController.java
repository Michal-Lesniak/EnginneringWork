package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.dto.car.CarDetails;
import com.example.backendengineeringwork.models.Car;
import com.example.backendengineeringwork.services.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/cars")
public class CarController extends AbstractController<Car, Long> {

    private final CarService carService;

    public CarController(CarService service, CarService carService){
        super(service);
        this.carService = carService;
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<CarDetails> getCarDetails(@PathVariable Long id){
        if(carService.findById(id).isPresent()){
            return ResponseEntity.ok().body(this.carService.getCarDetails(id));
        }
        return ResponseEntity.notFound().build();
    }

}
