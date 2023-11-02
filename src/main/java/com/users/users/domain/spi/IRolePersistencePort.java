package com.users.users.domain.spi;

import com.users.users.domain.model.Role;

public interface IRolePersistencePort {
    Role saveRole(Role role);
}
