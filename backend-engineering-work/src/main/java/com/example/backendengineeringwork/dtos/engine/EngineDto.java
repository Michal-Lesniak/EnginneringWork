package com.example.backendengineeringwork.dtos.engine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class EngineDto {
    private long id;
    private double engineCapacity;
    private int power;
    private int torque;
    private String fuel;
}
