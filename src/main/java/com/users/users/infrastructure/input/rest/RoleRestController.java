package com.users.users.infrastructure.input.rest;

import com.users.users.application.dto.request.RoleRequestDto;
import com.users.users.application.dto.request.UserRequestDto;
import com.users.users.application.dto.response.RoleResponseDto;
import com.users.users.application.handler.IRoleHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleRestController {

    private final IRoleHandler roleHandler;

    @Operation(summary = "Add a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveRole(@Valid @RequestBody RoleRequestDto roleRequestDto) {
        roleHandler.saveRole(roleRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get role")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "role returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RoleResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/{roleId}")
    public ResponseEntity<RoleResponseDto> getRole(@PathVariable Long roleId) {
        Optional<RoleResponseDto> roleDtoOptional = roleHandler.getRoleById(roleId);

        if (roleDtoOptional.isPresent()) {
            RoleResponseDto roleDto = roleDtoOptional.get();
            return ResponseEntity.ok(roleDto);
        } else {
            return ResponseEntity.notFound().build(); // Otra opción es devolver un ResponseEntity con estado 404 (Not Found)
        }
    }
}
