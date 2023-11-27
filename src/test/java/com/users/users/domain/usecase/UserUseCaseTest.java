package com.users.users.domain.usecase;

import com.users.users.domain.model.User;
import com.users.users.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class UserUseCaseTest {

    @Mock
    private IUserPersistencePort userPersistencePort;

    private UserUseCase userUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userUseCase = new UserUseCase(userPersistencePort);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveUser() {
        // Crear un usuario de ejemplo
        User user = new User();
        user.setId(1L); // Puedes asignar otros valores según tus necesidades

        // Configurar el comportamiento esperado para userPersistencePort.saveUser
        Mockito.when(userPersistencePort.saveUser(user)).thenReturn(user);

        // Llamar al método que deseas probar
        assertDoesNotThrow(() -> userUseCase.saveUser(user));

        // Verificar que el método saveUser en userPersistencePort se llamó una vez con el usuario proporcionado
        Mockito.verify(userPersistencePort, Mockito.times(1)).saveUser(user);
    }


}