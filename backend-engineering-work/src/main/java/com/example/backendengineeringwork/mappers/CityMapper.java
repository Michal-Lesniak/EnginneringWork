package com.example.backendengineeringwork.mappers;

import com.example.backendengineeringwork.commands.city.CityCreateCommand;
import com.example.backendengineeringwork.dtos.city.CityDto;
import com.example.backendengineeringwork.models.City;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {
    public static CityDto toDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .build();
    }

    public static City fromCommand(CityCreateCommand command) {
        return City.builder()
                .name(command.getName())
                .build();
    }

}
