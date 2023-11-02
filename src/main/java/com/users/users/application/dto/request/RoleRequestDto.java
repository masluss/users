package com.users.users.application.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class RoleRequestDto {

    private Long id;
    private String name;
    private String description;
}
