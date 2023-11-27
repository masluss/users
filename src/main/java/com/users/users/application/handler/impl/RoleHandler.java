package com.users.users.application.handler.impl;

import com.users.users.application.dto.request.RoleRequestDto;
import com.users.users.application.dto.response.RoleResponseDto;
import com.users.users.application.handler.IRoleHandler;
import com.users.users.application.mapper.IRoleRequestMapper;
import com.users.users.application.mapper.IRoleResponseMapper;
import com.users.users.domain.api.IRoleServicePort;
import com.users.users.domain.model.Role;
import com.users.users.infrastructure.exception.NoDataFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleHandler implements IRoleHandler {
    private final IRoleServicePort roleServicePort;
    private final IRoleRequestMapper roleRequestMapper;
    private final IRoleResponseMapper roleResponseMapper;

    @Override
    public void saveRole(RoleRequestDto roleRequestDto) {
        Role role = roleRequestMapper.toRole(roleRequestDto);
        roleServicePort.saveRole(role);
    }

    @Override
    public Optional<RoleResponseDto> getRoleById(Long id) {
        var role = roleServicePort.getRoleById(id);
        if(role.isEmpty()){
            throw new NoDataFoundException("Error in the entered data.");
        }
        return roleResponseMapper.toRoleOptional(role);
    }
}
