package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.dto.ImageCar.RequestUploadImageCarDto;
import com.example.backendengineeringwork.dto.ImageCar.ResponseImageCarDto;
import com.example.backendengineeringwork.models.ImageCar;
import com.example.backendengineeringwork.services.ImageCarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("api/v1/images")
public class ImageCarController {
    private final ImageCarService imageCarService;

    public ImageCarController(ImageCarService imageCarService) {
        this.imageCarService = imageCarService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseImageCarDto> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("carId") Long carId) throws IOException {
            return ResponseEntity.ok().body(imageCarService.uploadImage(new RequestUploadImageCarDto(file, carId)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteImage(@PathVariable("id") Long id) throws IOException {
        imageCarService.deleteImage(id);
        if(imageCarService.existImageById(id)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("car/{carId}")
    public ResponseEntity<ResponseImageCarDto> getFirstImageByCarId(@PathVariable("carId") Long carId){
        ResponseImageCarDto image = imageCarService.getImagesByCarId(carId).get(0);
        if(image != null){
            return ResponseEntity.ok().body(image);
        }
        return ResponseEntity.notFound().build();
    }
}
