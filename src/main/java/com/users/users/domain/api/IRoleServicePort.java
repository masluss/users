package com.users.users.domain.api;

import com.users.users.domain.model.Role;

import java.util.Optional;

public interface IRoleServicePort {
    void saveRole(Role role);
    Optional<Role> getRoleById(Long id);
}
