package com.example.backendengineeringwork.dtos.car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class CarDto {
    private long id;
    private String brand;
    private int rentPrizePerDay;
    private String modelName;
    private int productionYear;
}
