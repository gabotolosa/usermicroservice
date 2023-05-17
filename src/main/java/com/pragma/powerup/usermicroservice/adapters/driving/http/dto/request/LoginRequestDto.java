package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class LoginRequestDto {
    @NotBlank(message = "Mail should not be blank")
    @Email(message = "mail format user@domain.com")
    private String mail;
    @NotBlank(message = "Password should not be blank")
    private String password;
}
