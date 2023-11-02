package com.users.users.application.handler.impl;

import com.users.users.application.dto.request.RoleRequestDto;
import com.users.users.application.handler.IRoleHandler;
import com.users.users.application.mapper.IRoleRequestMapper;
import com.users.users.domain.api.IRoleServicePort;
import com.users.users.domain.model.Role;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleHandler implements IRoleHandler {
    private final IRoleServicePort roleServicePort;
    private final IRoleRequestMapper roleRequestMapper;
    @Override
    public void saveRole(RoleRequestDto roleRequestDto) {
        Role role = roleRequestMapper.toRole(roleRequestDto);
        roleServicePort.saveRole(role);
    }
}