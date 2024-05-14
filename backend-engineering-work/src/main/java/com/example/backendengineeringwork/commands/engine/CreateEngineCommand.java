package com.example.backendengineeringwork.commands.engine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class CreateEngineCommand {
    private double engineCapacity;
    private int power;
    private int torque;
    private String fuel;
}
