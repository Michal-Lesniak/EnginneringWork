package com.example.backendengineeringwork.repositories;

import com.example.backendengineeringwork.models.ImageCar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageCarRepository extends JpaRepository<ImageCar, Long> {
    Optional<ImageCar> findByName(String fileName);
    List<ImageCar> findAllByCar_Id(Long carId);
}
