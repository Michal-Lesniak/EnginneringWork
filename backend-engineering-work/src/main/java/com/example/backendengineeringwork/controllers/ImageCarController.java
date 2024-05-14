package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.commands.imageCar.RequestUploadImageCarDto;
import com.example.backendengineeringwork.dtos.imageCar.ResponseImageCarDto;
import com.example.backendengineeringwork.services.ImageCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/images")
public class ImageCarController {
    private final ImageCarService imageCarService;

    @PostMapping("/upload")
    public ResponseImageCarDto uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("carId") long carId) {
            return imageCarService.uploadImage(new RequestUploadImageCarDto(file, carId));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImage(@PathVariable("id") long id){
        imageCarService.deleteImage(id);
    }

    @GetMapping("car/{carId}")
    public ResponseImageCarDto getFirstImageByCarId(@PathVariable("carId") long carId){
        return imageCarService.getImagesByCarId(carId).get(0);
    }
}
