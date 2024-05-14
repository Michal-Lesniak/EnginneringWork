package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.commands.car.CreateCarCommand;
import com.example.backendengineeringwork.dtos.car.CarDetailsDto;
import com.example.backendengineeringwork.dtos.car.CarDto;
import com.example.backendengineeringwork.dtos.car.CarPreviewDto;
import com.example.backendengineeringwork.models.Car;
import com.example.backendengineeringwork.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cars")
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<CarDto> getAllCars() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public CarDto getCar(@PathVariable long id) {
        return carService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarDto createCar(@RequestBody CreateCarCommand command) {
        return carService.save(command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable long id) {
        carService.deleteById(id);
    }

    @GetMapping("/details/{id}")
    public CarDetailsDto getCarDetails(@PathVariable Long id){
           return carService.getCarDetails(id);
    }

    @GetMapping("/list")
    public List<CarPreviewDto> getAllCarsPreview() {
        return carService.getAllCarsPreview();
    }


}
