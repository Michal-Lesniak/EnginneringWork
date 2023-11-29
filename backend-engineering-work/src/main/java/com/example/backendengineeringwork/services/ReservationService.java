package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.dto.Reservation.ReservationDto;
import com.example.backendengineeringwork.dto.Reservation.ReservationViewDto;
import com.example.backendengineeringwork.models.Car;
import com.example.backendengineeringwork.models.City;
import com.example.backendengineeringwork.models.Reservation;
import com.example.backendengineeringwork.repositories.CarRepository;
import com.example.backendengineeringwork.repositories.CityRepository;
import com.example.backendengineeringwork.repositories.ReservationRepository;
import com.example.backendengineeringwork.security.user.User;
import com.example.backendengineeringwork.security.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationService {

    @Autowired
    private final ReservationRepository reservationRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final CarRepository carRepository;

    @Autowired
    private final CityRepository cityRepository;


    public List<ReservationDto> findAll() {
        List<Reservation> reservationList =  reservationRepository.findAll();
        return reservationList.stream().map(this::mapToReservastionDto).toList();
    }

    public ReservationDto findById(Long id) {
        return mapToReservastionDto(reservationRepository.findById(id).orElse(null ));
    }

    public ReservationDto save(ReservationDto reservationDto) {
        return mapToReservastionDto(reservationRepository.save(mapToReservation(reservationDto)));
    }

    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }

    public List<ReservationDto> getReservationByCarId(Long carId) {
        return reservationRepository.findByCarId(carId)
                .stream().map(this::mapToReservastionDto).toList();
    }

    public List<ReservationDto> getReservationByUserId(Long userId) {
        return reservationRepository.findByUserId(userId)
                .stream().map(this::mapToReservastionDto).toList();
    }

    public List<ReservationViewDto> getReservationByUserEmail(String email){
        return reservationRepository.findByUser_Email(email)
                .stream().map(this::mapToReservationViewDto).toList();
    }

    private ReservationDto mapToReservastionDto(Reservation reservation){
        return new ReservationDto(
                reservation.getId(),
                reservation.getCar().getId(),
                reservation.getUser().getId(),
                reservation.getRentCity().getId(),
                reservation.getArrivalCity().getId(),
                reservation.getRentDate(),
                reservation.getArrivalDate()
        );
    }

    private ReservationViewDto mapToReservationViewDto(Reservation reservation){
        Long costOfRent = reservation.getCar().getRentPrizePerDay() * Duration.between(reservation.getRentDate(), reservation.getArrivalDate()).toDays();
        return new ReservationViewDto(
                reservation.getCar().getBrand() + " " + reservation.getCar().getModel().getName(),
                reservation.getRentCity().getName(),
                reservation.getArrivalCity().getName(),
                reservation.getRentDate(),
                reservation.getArrivalDate(),
                costOfRent
        );
    }

    private Reservation mapToReservation(ReservationDto reservationDto){
        User user = userRepository.getReferenceById(reservationDto.userId());
        Car car = carRepository.getReferenceById(reservationDto.carId());
        City rentCity = cityRepository.getReferenceById(reservationDto.rentCityId());
        City arrivalCity = cityRepository.getReferenceById(reservationDto.arrivalCityId());
        return new Reservation(reservationDto.id(),
                car,
                reservationDto.rentDate(),
                reservationDto.arrivalDate(),
                user,
                rentCity,
                arrivalCity);
    }
}
