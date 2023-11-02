package com.users.users.infrastructure.out.jpa.adapter;

import com.users.users.domain.model.User;
import com.users.users.domain.spi.IUserPersistencePort;
import com.users.users.infrastructure.out.jpa.entity.UserEntity;
import com.users.users.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.users.users.infrastructure.out.jpa.repository.IUserEntityRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {
    private final IUserEntityRepository userEntityRepository;
    private final IUserEntityMapper userEntityMapper;
    @Override
    public User saveUser(User user) {
        UserEntity userEntity = userEntityRepository.save(userEntityMapper.toEntity(user));
        return userEntityMapper.toUser(userEntity);
    }
}
