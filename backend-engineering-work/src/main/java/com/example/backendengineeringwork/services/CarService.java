package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.dto.car.CarDetails;
import com.example.backendengineeringwork.models.Car;
import com.example.backendengineeringwork.models.Reservation;
import com.example.backendengineeringwork.repositories.CarRepository;
import com.example.backendengineeringwork.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService extends AbstractService<Car, Long>{

    private final CarRepository carRepository;

    private final ReservationRepository reservationRepository;

    public CarService(CarRepository repository, CarRepository carRepository, ReservationRepository reservationRepository){
        super(repository);
        this.carRepository = carRepository;
        this.reservationRepository = reservationRepository;
    }

    public CarDetails getCarDetails(Long id) {
        Car car = carRepository.getReferenceById(id);
        List<Reservation> reservationList = reservationRepository.findByCarId(id);
        List<LocalDateTime> localDates = new ArrayList<>();
        for(Reservation reservation:reservationList){
            LocalDateTime current = reservation.getRentDate();
            while (!current.isAfter(reservation.getArrivalDate())) {
                localDates.add(current);
                current = current.plusDays(1);
            }
        }
        return new CarDetails(car.getId(),
                car.getBrand(),
                car.getRentPrizePerDay(),
                car.getModel(),
                car.getProductionYear(),
                localDates);
    }


}
