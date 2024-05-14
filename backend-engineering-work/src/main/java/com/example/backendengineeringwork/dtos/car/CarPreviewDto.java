package com.example.backendengineeringwork.dtos.car;

import com.example.backendengineeringwork.dtos.imageCar.ResponseImageCarDto;

import java.util.List;

public record CarPreviewDto(Long id,
                            String name,
                            Integer rentPrizePerDay,
                            Double acceleration,
                            Integer power,
                            Integer torque,
                            Integer seats,
                            String transmission,
                            Integer productionYear,
                            List<ResponseImageCarDto> imageCarList) {
}
