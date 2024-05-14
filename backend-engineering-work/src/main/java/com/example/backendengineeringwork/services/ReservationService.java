package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.commands.reservation.CreateReservationCommand;
import com.example.backendengineeringwork.dtos.reservation.ReservationDto;
import com.example.backendengineeringwork.dtos.reservation.ReservationViewDto;
import com.example.backendengineeringwork.mappers.ReservationMapper;
import com.example.backendengineeringwork.models.Car;
import com.example.backendengineeringwork.models.City;
import com.example.backendengineeringwork.models.Reservation;
import com.example.backendengineeringwork.repositories.CarRepository;
import com.example.backendengineeringwork.repositories.CityRepository;
import com.example.backendengineeringwork.repositories.ReservationRepository;
import com.example.backendengineeringwork.models.User;
import com.example.backendengineeringwork.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.backendengineeringwork.mappers.ReservationMapper.toDto;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final CityRepository cityRepository;

    @Transactional(readOnly = true)
    public List<ReservationDto> findAll() {
        List<Reservation> reservationList =  reservationRepository.findAll();
        return reservationList.stream()
                .map(ReservationMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public ReservationDto findById(long id) {
        return toDto(reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found")));
    }

    @Transactional
    public ReservationDto save(CreateReservationCommand command) {
        if (command == null) throw new IllegalArgumentException("Command cannot be null");

        Reservation toSaveReservation = mapToReservation(command);

        Reservation saved = reservationRepository.save(toSaveReservation);
        return toDto(saved);
    }

    @Transactional
    public ReservationDto update(long id, CreateReservationCommand command) {
        if (command == null) throw new IllegalArgumentException("Command cannot be null");

        Reservation reservation = reservationRepository.findByIdWithLock(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found"));

        User user = userRepository.findById(command.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Car car = carRepository.findById(command.getCarId())
                .orElseThrow(() -> new EntityNotFoundException("Car not found"));
        City rentCity = cityRepository.findById(command.getRentCityId())
                .orElseThrow(() -> new EntityNotFoundException("Rent city not found"));
        City arrivalCity = cityRepository.findById(command.getArrivalCityId())
                .orElseThrow(() -> new EntityNotFoundException("Arrival city not found"));

        reservation.setCar(car);
        reservation.setRentDate(command.getRentDate());
        reservation.setArrivalDate(command.getArrivalDate());
        reservation.setUser(user);
        reservation.setRentCity(rentCity);
        reservation.setArrivalCity(arrivalCity);

        return toDto(reservation);
    }

    public void deleteById(long id) {
        reservationRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<ReservationDto> getReservationByCarId(long carId) {
        return reservationRepository.findByCarId(carId).stream()
                .map(ReservationMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<ReservationDto> getReservationByUserId(long userId) {
        return reservationRepository.findByUserId(userId).stream()
                .map(ReservationMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<ReservationViewDto> getReservationByUserEmail(String email){
        if (email == null) throw new IllegalArgumentException("Email cannot be null");

        return reservationRepository.findByUser_Email(email).stream()
                .map(ReservationMapper::toViewDto)
                .toList();
    }

    public Reservation mapToReservation(CreateReservationCommand command) {
        User user = userRepository.findById(command.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Car car = carRepository.findById(command.getCarId())
                .orElseThrow(() -> new EntityNotFoundException("Car not found"));
        City rentCity = cityRepository.findById(command.getRentCityId())
                .orElseThrow(() -> new EntityNotFoundException("Rent city not found"));
        City arrivalCity = cityRepository.findById(command.getArrivalCityId())
                .orElseThrow(() -> new EntityNotFoundException("Arrival city not found"));

        return Reservation.builder()
                .car(car)
                .rentDate(command.getRentDate())
                .arrivalDate(command.getArrivalDate())
                .user(user)
                .rentCity(rentCity)
                .arrivalCity(arrivalCity)
                .build();
    }
}
