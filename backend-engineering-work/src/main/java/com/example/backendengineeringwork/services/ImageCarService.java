package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.commands.imageCar.RequestUploadImageCarDto;
import com.example.backendengineeringwork.dtos.imageCar.ResponseImageCarDto;
import com.example.backendengineeringwork.exceptions.ImageDeleteException;
import com.example.backendengineeringwork.exceptions.ImageUploadException;
import com.example.backendengineeringwork.models.ImageCar;
import com.example.backendengineeringwork.repositories.CarRepository;
import com.example.backendengineeringwork.repositories.ImageCarRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageCarService {
    private final ImageCarRepository imageCarRepository;
    private final CarRepository carRepository;

    @Transactional
    public ResponseImageCarDto uploadImage(RequestUploadImageCarDto uploadImage) {
        if (uploadImage.file() == null) {
            throw new IllegalArgumentException("File cannot be null");
        }

        String rootPath = "C:\\Users\\Michał\\Desktop\\EnginneringWork\\frontend-engineering-work\\src\\assets";
        String fullPath = rootPath + "\\" + uploadImage.carId() + "\\" + uploadImage.file().getOriginalFilename();
        Path path = Paths.get(fullPath);
        ImageCar image = new ImageCar();
        try {
            if (!Files.exists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }

            image.setName(uploadImage.file().getOriginalFilename());
            image.setType(uploadImage.file().getContentType());
            image.setPath(fullPath);
            image.setCar(carRepository.findById(uploadImage.carId())
                    .orElseThrow(() -> new EntityNotFoundException("Car with id: " + uploadImage.carId() + " not found")));
            uploadImage.file().transferTo(new File(fullPath));
        } catch (IOException e) {
            throw new ImageUploadException("An error occurred while uploading the image", e);
        }

        ImageCar imageCar =  imageCarRepository.save(image);

        return new ResponseImageCarDto(imageCar.getId(), imageCar.getName(), imageCar.getPath());
    }

    @Transactional
    public void deleteImage(long id)  {
        ImageCar imageCar = imageCarRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Image with id: " + id + " not found"));

        Path path = Paths.get(imageCar.getPath());
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                throw new ImageDeleteException("An error occurred while deleting the image", e);
            }
        }
        imageCarRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<ResponseImageCarDto> getImagesByCarId(long carId){
        List<ImageCar> imageCarArrayList = imageCarRepository.findAllByCar_Id(carId);
        return imageCarArrayList.stream().map(imageCar -> new ResponseImageCarDto(imageCar.getId(), imageCar.getName(), imageCar.getPath())).toList();
    }

    public boolean existImageById(long id){
        return imageCarRepository.existsById(id);
    }
}
