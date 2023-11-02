package com.users.users.application.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
@Getter
@Setter
@Validated
public class UserRequestDto {

    @Pattern(regexp = "^[a-zA-Z]{2,20}$", message = "El nombre debe tener entre 2 y 20 caracteres y contener solo letras")
    private String name;
    @Pattern(regexp = "^[a-zA-Z]{2,20}$", message = "El nombre debe tener entre 2 y 20 caracteres y contener solo letras")
    private String lastname;
    @Email(message = "El email debe tener una estructura válida")
    private String email;
    @Min(value = 10000000, message = "El código debe ser mayor o igual a 10,000,000")
    @Max(value = 999999999999999L, message = "El código debe ser menor o igual a 999,999,999,999,999")
    private Long code;

}
