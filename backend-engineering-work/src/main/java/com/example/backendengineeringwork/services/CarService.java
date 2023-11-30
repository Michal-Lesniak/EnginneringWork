package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.dto.ImageCar.ResponseImageCarDto;
import com.example.backendengineeringwork.dto.car.CarDetails;
import com.example.backendengineeringwork.dto.car.CarPreview;
import com.example.backendengineeringwork.models.Car;
import com.example.backendengineeringwork.models.Reservation;
import com.example.backendengineeringwork.repositories.CarRepository;
import com.example.backendengineeringwork.repositories.ImageCarRepository;
import com.example.backendengineeringwork.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService extends AbstractService<Car, Long>{

    private final CarRepository carRepository;

    private final ReservationRepository reservationRepository;

    private final ImageCarService imageCarService;

    public CarService(CarRepository repository, CarRepository carRepository, ReservationRepository reservationRepository, ImageCarRepository imageCarRepository, ImageCarService imageCarService){
        super(repository);
        this.carRepository = carRepository;
        this.reservationRepository = reservationRepository;
        this.imageCarService = imageCarService;
    }

    public CarDetails getCarDetails(Long id) {
        Car car = carRepository.getReferenceById(id);
        List<Reservation> reservationList = reservationRepository.findByCarId(id);
        List<LocalDateTime> localDates = new ArrayList<>();
        List<ResponseImageCarDto> imageCarDtoList = imageCarService.getImagesByCarId(car.getId());

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
                localDates,
                imageCarDtoList);
    }

    public List<CarPreview> getAllCars(){
        List<Car> cars = carRepository.findAll();
        return cars.stream().map(car -> new CarPreview(car.getId(),
                car.getBrand() + " " + car.getModel().getName(),
                car.getRentPrizePerDay(),
                car.getModel().getAcceleration(),
                car.getModel().getEngine().getPower(),
                car.getModel().getEngine().getTorque(),
                car.getModel().getSeats(),
                car.getModel().getTransmission(),
                car.getProductionYear(),
                imageCarService.getImagesByCarId(car.getId()))).toList();
    }


}
