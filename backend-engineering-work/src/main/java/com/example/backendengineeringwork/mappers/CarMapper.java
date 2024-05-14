package com.example.backendengineeringwork.mappers;

import com.example.backendengineeringwork.commands.car.CreateCarCommand;
import com.example.backendengineeringwork.dtos.car.CarDto;
import com.example.backendengineeringwork.models.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    public static CarDto toDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .rentPrizePerDay(car.getRentPrizePerDay())
                .modelName(car.getModel().getName())
                .productionYear(car.getProductionYear())
                .build();
    }

    public static Car fromCommand(CreateCarCommand command) {
        return Car.builder()
                .brand(command.getBrand())
                .rentPrizePerDay(command.getRentPrizePerDay())
                .model(CarModelMapper.fromCommand(command.getModelCreateCommand()))
                .productionYear(command.getProductionYear())
                .build();
    }
}
