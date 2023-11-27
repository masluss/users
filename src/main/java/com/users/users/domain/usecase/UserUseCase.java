package com.users.users.domain.usecase;

import com.users.users.domain.api.IUserServicePort;
import com.users.users.domain.model.User;
import com.users.users.domain.spi.IUserPersistencePort;
import com.users.users.infrastructure.exception.NoDataFoundException;

public class UserUseCase implements IUserServicePort {

    //aquí traer el rol por medio de la interfaz, no los casos de usos!
    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveUser(User user) {

        if(user==null){
            throw new NoDataFoundException("Usuario sin información");
        }
        userPersistencePort.saveUser(user);
    }
}
