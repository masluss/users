package com.users.users.application.handler;

import com.users.users.application.dto.request.RoleRequestDto;
import com.users.users.application.dto.response.RoleResponseDto;

import java.util.Optional;

public interface IRoleHandler {
    void saveRole(RoleRequestDto roleRequestDto);
    Optional<RoleResponseDto> getRoleById(Long id);
}
