package com.example.backendengineeringwork.dto;

import com.example.backendengineeringwork.models.Car;
import org.springframework.web.multipart.MultipartFile;

public record uploadImageCarDto(
        MultipartFile file,
        Car car
) {
}
