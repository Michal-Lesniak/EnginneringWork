package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.dto.uploadImageCarDto;
import com.example.backendengineeringwork.models.ImageCar;
import com.example.backendengineeringwork.repositories.ImageCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ImageCarService {
    @Autowired
    private ImageCarRepository imageCarRepository;

    private final String PATH = "C:\\workspace\\";


    public ImageCar uploadImage(uploadImageCarDto uploadImage) throws IOException {
        String fullPath = PATH + "\\" + uploadImage.car().getId() + "\\" + uploadImage.file().getOriginalFilename();
        ImageCar image = new ImageCar();
        image.setName(uploadImage.file().getOriginalFilename());
        image.setType(uploadImage.file().getContentType());
        image.setPath(fullPath);
        image.setCar(uploadImage.car());

        uploadImage.file().transferTo(new File(fullPath));
        return imageCarRepository.save(image);
    }

}
