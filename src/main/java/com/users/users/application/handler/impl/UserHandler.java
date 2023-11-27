package com.users.users.application.handler.impl;

import com.users.users.application.dto.request.UserRequestDto;
import com.users.users.application.dto.response.Response;
import com.users.users.application.handler.IUserHandler;
import com.users.users.application.mapper.IUserRequestMapper;
import com.users.users.domain.api.IUserServicePort;
import com.users.users.domain.model.User;
import com.users.users.infrastructure.exception.NoDataFoundException;
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
    public Response<Void> saveUser(UserRequestDto userRequestDto) {
        User user = userRequestMapper.toUser(userRequestDto);
        if(user == null){
            throw new NoDataFoundException("Error in the entered data.");
        }
        userServicePort.saveUser(user);
        return null;
    }
}
