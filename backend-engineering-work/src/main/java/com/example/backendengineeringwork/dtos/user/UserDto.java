package com.example.backendengineeringwork.dtos.user;

import com.example.backendengineeringwork.models.Person;

public record UserDto(
        Long id,
        Person person,
        String mobilePhone,
        String email
) {
}
