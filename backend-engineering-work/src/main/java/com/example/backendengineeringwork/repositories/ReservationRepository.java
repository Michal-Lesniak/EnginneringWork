package com.example.backendengineeringwork.repositories;

import com.example.backendengineeringwork.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByCarId(Long carId);
    List<Reservation> findByUserId(Long userId);
}