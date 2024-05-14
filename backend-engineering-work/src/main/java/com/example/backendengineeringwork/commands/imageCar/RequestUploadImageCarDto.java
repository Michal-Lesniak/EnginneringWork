package com.example.backendengineeringwork.commands.imageCar;

import org.springframework.web.multipart.MultipartFile;

public record RequestUploadImageCarDto(
        MultipartFile file,
        Long carId
) {
}
