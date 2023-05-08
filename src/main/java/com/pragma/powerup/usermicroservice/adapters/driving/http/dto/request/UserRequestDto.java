package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.RoleResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserRequestDto {
    private String name;
    private String surname;
    private String dniNumber;
    private String phone;
    private String mail;
    private String password;
    private String token;
    //private RoleResponseDto role;
}
