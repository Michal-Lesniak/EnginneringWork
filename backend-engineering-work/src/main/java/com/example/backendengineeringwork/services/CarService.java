package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.commands.car.CreateCarCommand;
import com.example.backendengineeringwork.dtos.car.CarDetailsDto;
import com.example.backendengineeringwork.dtos.car.CarDto;
import com.example.backendengineeringwork.dtos.car.CarPreviewDto;
import com.example.backendengineeringwork.dtos.imageCar.ResponseImageCarDto;
import com.example.backendengineeringwork.exceptions.ArgumentCannotBeNullException;
import com.example.backendengineeringwork.exceptions.NotFoundException;
import com.example.backendengineeringwork.mappers.CarMapper;
import com.example.backendengineeringwork.models.Car;
import com.example.backendengineeringwork.models.ImageCar;
import com.example.backendengineeringwork.models.Reservation;
import com.example.backendengineeringwork.repositories.CarRepository;
import com.example.backendengineeringwork.repositories.ImageCarRepository;
import com.example.backendengineeringwork.repositories.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.backendengineeringwork.mappers.CarMapper.fromCommand;
import static com.example.backendengineeringwork.mappers.CarMapper.toDto;

@Service
@RequiredArgsConstructor
public class CarService{

    private final CarRepository carRepository;

    private final ReservationRepository reservationRepository;

    private final ImageCarRepository imageCarRepository;

    @Transactional(readOnly = true)
    public List<CarDto> findAll() {
        return carRepository.findAll().stream()
                .map(CarMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public CarDto findById(long id) {
        Car car = carRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Car with id: " + id + " not found")
        );
        return toDto(car);
    }

    public CarDto save(CreateCarCommand command) {
        if(command == null) throw new ArgumentCannotBeNullException("Car cannot be null");

        Car car = carRepository.save(fromCommand(command));
        return toDto(car);
    }

    public void deleteById(long id) {
        carRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public CarDetailsDto getCarDetails(long id) {
        Car car = carRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Car with id: " + id + " not found")
        );

        List<Reservation> reservationList = reservationRepository.findByCarId(id);
        List<LocalDateTime> localDates = new ArrayList<>();
        List<ImageCar> imageCarArrayList = imageCarRepository.findAllByCar_Id(car.getId());

        List<ResponseImageCarDto> imageCarDtoList = imageCarArrayList.stream()
                .map(imageCar -> new ResponseImageCarDto(imageCar.getId(), imageCar.getName(), imageCar.getPath())).toList();


        for(Reservation reservation:reservationList){
            LocalDateTime current = reservation.getRentDate();
            while (!current.isAfter(reservation.getArrivalDate())) {
                localDates.add(current);
                current = current.plusDays(1);
            }
        }
        return new CarDetailsDto(car.getId(),
                car.getBrand(),
                car.getRentPrizePerDay(),
                car.getModel(),
                car.getProductionYear(),
                localDates,
                imageCarDtoList);
    }

    @Transactional(readOnly = true)
    public List<CarPreviewDto> getAllCarsPreview(){
        List<Car> cars = carRepository.findAll();

        return cars.stream().map(car -> new CarPreviewDto(car.getId(),
                car.getBrand() + " " + car.getModel().getName(),
                car.getRentPrizePerDay(),
                car.getModel().getAcceleration(),
                car.getModel().getEngine().getPower(),
                car.getModel().getEngine().getTorque(),
                car.getModel().getSeats(),
                car.getModel().getTransmission(),
                car.getProductionYear(),
                imageCarRepository.findAllByCar_Id(car.getId()).stream()
                        .map(imageCar -> new ResponseImageCarDto(imageCar.getId(), imageCar.getName(), imageCar.getPath()))
                        .toList()))
                .toList();
    }
}
