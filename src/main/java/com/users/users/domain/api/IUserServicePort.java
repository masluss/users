package com.users.users.domain.api;

import com.users.users.domain.model.User;

public interface IUserServicePort {
    void saveUser(User user);
}
