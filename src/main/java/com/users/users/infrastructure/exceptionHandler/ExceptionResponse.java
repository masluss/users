package com.users.users.infrastructure.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ExceptionResponse {
    private String message;
    private String path;
    private LocalDateTime date;
}
