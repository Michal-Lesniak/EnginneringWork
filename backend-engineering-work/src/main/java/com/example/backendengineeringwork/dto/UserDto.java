package com.example.backendengineeringwork.dto;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class UserDto {

    private Long id;

    @NotNull
    private Long personId;

    @NotBlank
    private String login;

    @NotBlank
    @Size(min = 8)
    private String password;

    @NotNull
    private Long roleId;
}
