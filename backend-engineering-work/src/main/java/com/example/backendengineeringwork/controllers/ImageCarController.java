package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.dto.uploadImageCarDto;
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
    public ResponseEntity<ImageCar> uploadImage(@RequestParam("carImage") uploadImageCarDto uploadCarImageData) throws IOException {
        ImageCar imageCar = imageCarService.uploadImage(uploadCarImageData); //TODO sprawdz czy operacja save zwraca odpowiednie dane do ImageCaer
        return ResponseEntity.ok().body(imageCar); //TODO dodaj walidacje i zwroc odpowiedni kod bledu
    }
}
