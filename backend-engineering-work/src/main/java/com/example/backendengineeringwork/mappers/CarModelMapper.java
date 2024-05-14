package com.example.backendengineeringwork.mappers;

import com.example.backendengineeringwork.commands.carModel.CreateCarModelCommand;
import com.example.backendengineeringwork.dtos.carModel.CarModelDto;
import com.example.backendengineeringwork.models.CarModel;
import org.springframework.stereotype.Component;

@Component
public class CarModelMapper {
    public static CarModelDto toDto(CarModel carModel){
        return CarModelDto.builder()
                .name(carModel.getName())
                .engine(carModel.getEngine())
                .type(carModel.getType())
                .seats(carModel.getSeats())
                .drive(carModel.getDrive())
                .transmission(carModel.getTransmission())
                .topSpeed(carModel.getTopSpeed())
                .acceleration(carModel.getAcceleration())
                .fuelConsumption(carModel.getFuelConsumption())
                .build();
    }

    public static CarModel fromCommand(CreateCarModelCommand command){
        return CarModel.builder()
                .name(command.getName())
                .engine(EngineMapper.fromCommand(command.getEngineCommand()))
                .type(command.getType())
                .seats(command.getSeats())
                .drive(command.getDrive())
                .transmission(command.getTransmission())
                .topSpeed(command.getTopSpeed())
                .acceleration(command.getAcceleration())
                .fuelConsumption(command.getFuelConsumption())
                .build();
    }
}
