package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService extends AbstractService<Reservation, Long>{
    public ReservationService(JpaRepository<Reservation, Long> repository) {
        super(repository);
    }
}
