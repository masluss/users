package com.users.users.domain.usecase;

import com.users.users.domain.api.IRoleServicePort;
import com.users.users.domain.exception.DomainException;
import com.users.users.domain.model.Role;
import com.users.users.domain.spi.IRolePersistencePort;

import java.util.Optional;

public class RoleUseCase implements IRoleServicePort {
    private final IRolePersistencePort rolePersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public void saveRole(Role role) {
        rolePersistencePort.saveRole(role);
    }

    @Override
    public Optional<Role> getRoleById(Long id) {
        Optional<Role> optionalRole = rolePersistencePort.getRoleById(id);
        return Optional.ofNullable(optionalRole.orElseThrow(() -> new DomainException("No se encontró un Rol con el id proporcionado: " + id)));
    }
}
