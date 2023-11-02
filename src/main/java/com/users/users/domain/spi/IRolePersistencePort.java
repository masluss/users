package com.users.users.domain.spi;

import com.users.users.domain.model.Role;

import java.util.Optional;

public interface IRolePersistencePort {
    Role saveRole(Role role);
    Optional<Role> getRoleById(Long id);
}
