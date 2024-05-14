package com.example.backendengineeringwork.dtos.carModel;

import com.example.backendengineeringwork.models.Engine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class CarModelDto {
    private String name;
    private Engine engine;
    private String type;
    private int seats;
    private String drive;
    private String transmission;
    private int topSpeed;
    private double acceleration;
    private double fuelConsumption;
}
