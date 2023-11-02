package com.users.users.domain.spi;

import com.users.users.domain.model.User;

public interface IUserPersistencePort {
    User saveUser(User user);
}
