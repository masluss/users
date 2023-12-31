package com.users.users.infrastructure.out.jpa.adapter;

import com.users.users.domain.model.Role;
import com.users.users.domain.spi.IRolePersistencePort;
import com.users.users.infrastructure.out.jpa.entity.RoleEntity;
import com.users.users.infrastructure.out.jpa.mapper.IRoleEntityMapper;
import com.users.users.infrastructure.out.jpa.repository.IRoleEntityRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class RoleJpaAdapter implements IRolePersistencePort {
    private final IRoleEntityMapper roleEntityMapper;
    private final IRoleEntityRepository roleEntityRepository;
    @Override
    public Role saveRole(Role role) {
        RoleEntity roleEntity = roleEntityRepository.save(roleEntityMapper.toEntity(role));
        return roleEntityMapper.toRole(roleEntity);
    }

    @Override
    public Optional<Role> getRoleById(Long id) {
        Optional<RoleEntity> rolEntity = roleEntityRepository.findById(id);
        return roleEntityMapper.toRoleOptional(rolEntity);
    }
}
