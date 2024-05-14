package com.example.backendengineeringwork.repositories;

import com.example.backendengineeringwork.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {
}