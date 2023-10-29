package com.example.backendengineeringwork.security.user;

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
    private Enum<Role> role;
}
