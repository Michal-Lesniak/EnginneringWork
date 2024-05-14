package com.example.backendengineeringwork.commands.city;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class CityCreateCommand {
    private String name;
}
