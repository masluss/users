package com.users.users.application.handler;

import com.users.users.application.dto.request.UserRequestDto;

public interface IUserHandler {
    void saveUser(UserRequestDto userRequestDto);
}
