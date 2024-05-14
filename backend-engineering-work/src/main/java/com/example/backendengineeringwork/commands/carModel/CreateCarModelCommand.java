package com.example.backendengineeringwork.commands.carModel;

import com.example.backendengineeringwork.commands.engine.CreateEngineCommand;
import com.example.backendengineeringwork.models.Engine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class CreateCarModelCommand {
    private String name;
    private CreateEngineCommand engineCommand;
    private String type;
    private int seats;
    private String drive;
    private String transmission;
    private int topSpeed;
    private double acceleration;
    private double fuelConsumption;
}
