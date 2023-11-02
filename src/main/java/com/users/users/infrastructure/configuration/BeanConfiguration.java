package com.users.users.infrastructure.configuration;

import com.users.users.domain.api.IRoleServicePort;
import com.users.users.domain.api.IUserServicePort;
import com.users.users.domain.spi.IRolePersistencePort;
import com.users.users.domain.spi.IUserPersistencePort;
import com.users.users.domain.usecase.RoleUseCase;
import com.users.users.domain.usecase.UserUseCase;
import com.users.users.infrastructure.out.jpa.adapter.RoleJpaAdapter;
import com.users.users.infrastructure.out.jpa.adapter.UserJpaAdapter;
import com.users.users.infrastructure.out.jpa.mapper.IRoleEntityMapper;
import com.users.users.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.users.users.infrastructure.out.jpa.repository.IRoleEntityRepository;
import com.users.users.infrastructure.out.jpa.repository.IUserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUserEntityRepository userEntityRepository;
    private final IUserEntityMapper userEntityMapper;
    private final IRoleEntityRepository roleEntityRepository;
    private final IRoleEntityMapper roleEntityMapper;

    @Bean
    public IUserPersistencePort userPersistencePort(){
        return new UserJpaAdapter(userEntityRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    public IRolePersistencePort rolePersistencePort(){
        return new RoleJpaAdapter(roleEntityMapper, roleEntityRepository);
    }

    @Bean
    public IRoleServicePort roleServicePort() {
        return new RoleUseCase(rolePersistencePort());
    }


}
