package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.dto.ImageCar.RequestUploadImageCarDto;
import com.example.backendengineeringwork.dto.ImageCar.ResponseImageCarDto;
import com.example.backendengineeringwork.models.ImageCar;
import com.example.backendengineeringwork.repositories.CarRepository;
import com.example.backendengineeringwork.repositories.ImageCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageCarService {
    private final ImageCarRepository imageCarRepository;
    private final CarRepository carRepository;

    private final String PATH = "C:\\Users\\Michał\\Desktop\\EnginneringWork\\frontend-engineering-work\\src\\assets";

    public ImageCarService(CarRepository carRepository, ImageCarRepository imageCarRepository) {
        this.carRepository = carRepository;
        this.imageCarRepository = imageCarRepository;
    }


    public ResponseImageCarDto uploadImage(RequestUploadImageCarDto uploadImage) throws IOException {
        String fullPath = PATH + "\\" + uploadImage.carId() + "\\" + uploadImage.file().getOriginalFilename();
        Path path = Paths.get(fullPath);

        if (!Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }
        ImageCar image = new ImageCar();
        image.setName(uploadImage.file().getOriginalFilename());
        image.setType(uploadImage.file().getContentType());
        image.setPath(fullPath);
        image.setCar(carRepository.getReferenceById(uploadImage.carId()));

        uploadImage.file().transferTo(new File(fullPath));
        ImageCar imageCar =  imageCarRepository.save(image);
        return new ResponseImageCarDto(imageCar.getId(), imageCar.getName(), imageCar.getPath());
    }

    public void deleteImage(Long id) throws IOException {
        ImageCar imageCar = imageCarRepository.getReferenceById(id);
        Path path = Paths.get(imageCar.getPath());
        if (Files.exists(path)) {
            Files.delete(path);
        }
        imageCarRepository.deleteById(id);
    }

    public List<ResponseImageCarDto> getImagesByCarId(Long carId){
        List<ImageCar> imageCarArrayList = imageCarRepository.findAllByCar_Id(carId);
        return imageCarArrayList.stream().map(imageCar -> new ResponseImageCarDto(imageCar.getId(), imageCar.getName(), imageCar.getPath())).toList();
    }

    public Boolean existImageById(Long id){
        return imageCarRepository.existsById(id);
    }
}
