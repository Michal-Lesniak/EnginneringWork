package com.example.backendengineeringwork.dto.car;

import com.example.backendengineeringwork.dto.ImageCar.ResponseImageCarDto;
import com.example.backendengineeringwork.models.CarModel;

import java.util.List;

public record CarPreview(Long id,
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
