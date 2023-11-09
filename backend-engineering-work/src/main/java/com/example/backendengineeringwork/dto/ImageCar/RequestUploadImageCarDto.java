package com.example.backendengineeringwork.dto.ImageCar;

import com.example.backendengineeringwork.models.Car;
import org.springframework.web.multipart.MultipartFile;

public record RequestUploadImageCarDto(
        MultipartFile file,
        Car car
) {
}
