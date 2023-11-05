package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.models.Person;
import com.example.backendengineeringwork.models.Reservation;
import com.example.backendengineeringwork.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService extends AbstractService<Reservation, Long>{

    private final ReservationRepository reservationRepository;

    public ReservationService(JpaRepository<Reservation, Long> repository, ReservationRepository reservationRepository) {
        super(repository);
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservationByCarId(Long carId) { return reservationRepository.findByCarId(carId);}

    public List<Reservation> getReservationByUserId(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

}
