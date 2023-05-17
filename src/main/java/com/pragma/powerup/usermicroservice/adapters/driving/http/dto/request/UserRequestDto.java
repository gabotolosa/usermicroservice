package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import com.pragma.powerup.usermicroservice.domain.model.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserRequestDto {
    @NotBlank(message = "name must not be blank")
    private String name;

    @NotBlank(message = "surname must not be blank")
    private String surname;

    @Pattern(regexp = "\\d+", message = "Dni must be numeric")
    @Size(min = 4, max = 10, message = "Dni must be between 4 and 10 digit")
    @Column(unique = true)
    private String dniNumber;

    @Pattern(regexp = "\\+?\\d+", message = "phone may be contain character '+' ")
    @Size(min = 5, max = 13, message = "phone must be between 5 and 13 digit")
    private String phone;

    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "birthdate must be format YYYY-MM-DD")
    @PastOrPresent(message = "birthdate must past date ")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthdate;

    @Email(message = "mail must be format user@domain.com")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]{2,15}@[A-Za-z0-9-]+(\\.[A-Za-z]{2,5}){1,2}(\\.[A-Za-z]{2,3})?$")
    @Column(unique = true)
    private String mail;

    @NotBlank(message = "password must not be blank")
    private String password;
    private String token;
    //private Role role;

}
