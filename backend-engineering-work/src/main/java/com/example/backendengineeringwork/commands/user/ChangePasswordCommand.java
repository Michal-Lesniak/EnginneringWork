package com.example.backendengineeringwork.commands.user;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChangePasswordCommand {

    private String currentPassword;
    private String newPassword;
    private String confirmationPassword;
}

