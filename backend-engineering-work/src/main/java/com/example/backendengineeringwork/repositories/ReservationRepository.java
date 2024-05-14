package com.example.backendengineeringwork.repositories;

import com.example.backendengineeringwork.models.Reservation;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT r FROM Reservation r WHERE r.id = :id")
    Optional<Reservation> findByIdWithLock(long id);
    List<Reservation> findByCarId(Long carId);
    List<Reservation> findByUserId(Long userId);
    List<Reservation> findByUser_Email(String email);
}