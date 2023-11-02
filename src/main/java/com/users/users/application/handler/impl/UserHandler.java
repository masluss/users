package com.users.users.application.handler.impl;

import com.users.users.application.dto.request.UserRequestDto;
import com.users.users.application.handler.IUserHandler;
import com.users.users.application.mapper.IUserRequestMapper;
import com.users.users.domain.api.IUserServicePort;
import com.users.users.domain.model.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    @Override
    public void saveUser(UserRequestDto userRequestDto) {
        User user = userRequestMapper.toUser(userRequestDto);
        userServicePort.saveUser(user);
    }
}
