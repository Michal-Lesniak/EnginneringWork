package com.example.backendengineeringwork.dtos.car;

import com.example.backendengineeringwork.dtos.imageCar.ResponseImageCarDto;
import com.example.backendengineeringwork.models.CarModel;

import java.time.LocalDateTime;
import java.util.List;

public record CarDetailsDto(
        Long id,
        String brand,
        Integer rentPrizePerDay,
        CarModel model,
        Integer productionYear,
        List<LocalDateTime> bookedDays,
        List<ResponseImageCarDto> imageCarList
) {
}
