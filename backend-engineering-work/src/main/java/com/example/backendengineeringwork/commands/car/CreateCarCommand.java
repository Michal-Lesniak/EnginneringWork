package com.example.backendengineeringwork.commands.car;

import com.example.backendengineeringwork.commands.carModel.CreateCarModelCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class CreateCarCommand {
    private String brand;
    private int rentPrizePerDay;
    private CreateCarModelCommand modelCreateCommand;
    private int productionYear;
}
