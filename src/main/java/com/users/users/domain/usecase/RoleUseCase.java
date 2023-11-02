package com.users.users.domain.usecase;

import com.users.users.domain.api.IRoleServicePort;
import com.users.users.domain.model.Role;
import com.users.users.domain.spi.IRolePersistencePort;

public class RoleUseCase implements IRoleServicePort {
    private final IRolePersistencePort rolePersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public void saveRole(Role role) {
        rolePersistencePort.saveRole(role);
    }
}
