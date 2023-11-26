package com.example.backendengineeringwork.security.user.dto;

import com.example.backendengineeringwork.models.Person;

public record UserProfileDto(
        Long id,
        Person person,
        String mobilePhone,
        String email
) {
}
