package com.example.backendengineeringwork.repositories;

import com.example.backendengineeringwork.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CarRepository extends JpaRepository<Car, Long> {
}