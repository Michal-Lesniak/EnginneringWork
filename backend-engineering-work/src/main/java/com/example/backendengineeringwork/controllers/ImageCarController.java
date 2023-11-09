package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.dto.ImageCar.RequestUploadImageCarDto;
import com.example.backendengineeringwork.models.ImageCar;
import com.example.backendengineeringwork.services.ImageCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/image")
public class ImageCarController {
    @Autowired
    private ImageCarService imageCarService;

    @PostMapping("/upload")
    public ResponseEntity<ImageCar> uploadImage(@RequestParam("carImage") RequestUploadImageCarDto uploadCarImageData) throws IOException {
        ImageCar imageCar = imageCarService.uploadImage(uploadCarImageData); //TODO sprawdz czy operacja save zwraca odpowiednie dane do ImageCaer
        if(imageCarService.existImageById(imageCar.getId())){
            return ResponseEntity.ok().body(imageCar);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteImage(@RequestParam("carId") Long carId ){
        imageCarService.deleteImage(carId);
        if(imageCarService.existImageById(carId)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
