package com.users.users.infrastructure.input.rest;

import com.users.users.application.dto.request.UserRequestDto;
import com.users.users.application.dto.response.RoleResponseDto;
import com.users.users.application.handler.IRoleHandler;
import com.users.users.application.handler.IUserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRestController {
    private final IUserHandler userHandler;
    private final IRoleHandler roleHandler;
    @Operation(summary = "Add a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PostMapping("/decano")
    public ResponseEntity<Void> saveUserDirector(@Valid @RequestBody UserRequestDto userRequestDto) {
        Optional<RoleResponseDto> role = roleHandler.getRoleById(userRequestDto.getRole().getId());
        if (role.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        userHandler.saveUser(userRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @Operation(summary = "Add a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PostMapping("/director")
    public ResponseEntity<Void> saveUserTheacher(@Valid @RequestBody UserRequestDto userRequestDto) {
        Optional<RoleResponseDto> role = roleHandler.getRoleById(userRequestDto.getRole().getId());
        if (role.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        userHandler.saveUser(userRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Add a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PostMapping("/alumno")
    public ResponseEntity<Void> saveUserStudent(@Valid @RequestBody UserRequestDto userRequestDto) {
        Optional<RoleResponseDto> role = roleHandler.getRoleById(userRequestDto.getRole().getId());
        if (role.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        userHandler.saveUser(userRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
