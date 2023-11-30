package com.example.backendengineeringwork.dto.car;

import com.example.backendengineeringwork.dto.ImageCar.ResponseImageCarDto;
import com.example.backendengineeringwork.models.CarModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record CarDetails(
        Long id,
        String brand,
        Integer rentPrizePerDay,
        CarModel model,
        Integer productionYear,
        List<LocalDateTime> bookedDays,
        List<ResponseImageCarDto> imageCarList
) {
}
