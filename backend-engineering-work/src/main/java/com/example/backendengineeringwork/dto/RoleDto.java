package com.example.backendengineeringwork.dto;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class RoleDto {

    private Long id;

    @NotBlank
    private String name;
}