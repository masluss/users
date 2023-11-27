package com.users.users.application.handler;

import com.users.users.application.dto.request.UserRequestDto;
import com.users.users.application.dto.response.Response;

public interface IUserHandler {
    Response<Void> saveUser(UserRequestDto userRequestDto);
}
