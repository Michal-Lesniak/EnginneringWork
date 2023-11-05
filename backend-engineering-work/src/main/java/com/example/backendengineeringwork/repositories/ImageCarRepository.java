package com.example.backendengineeringwork.repositories;

import com.example.backendengineeringwork.models.ImageCar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageCarRepository extends JpaRepository<ImageCar, Long> {
    Optional<ImageCar> findByName(String fileName);
}
