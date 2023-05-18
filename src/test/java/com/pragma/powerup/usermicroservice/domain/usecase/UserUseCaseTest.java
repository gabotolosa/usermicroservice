package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter.UserDetailsServiceImpl;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IAuthHandler;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import com.pragma.powerup.usermicroservice.factory.UserFactoryDataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class UserUseCaseTest {
    @InjectMocks
    UserUseCase userUseCase;

    @Mock
    IUserPersistencePort userPersistencePort;

    @Mock
    IAuthHandler authHandler;

    @Mock
    UserDetailsServiceImpl userDetailsService;

    void should_login_user_given_valid_email_and_password(){
        User user = UserFactoryDataTest.getUser();
        Mockito.when(authHandler.tokenIsValid("Bearer token")).thenReturn(true);
    }

    @Test
    void mustSaveAUserOwner(){
        User owner = UserFactoryDataTest.getOwner();
        userUseCase.saveOwner(owner);
        Mockito.verify(userPersistencePort).saveOwner(Mockito.any(User.class));
    }

    @Test
    void mustSaveAUser(){
        User user = UserFactoryDataTest.getUser();
        userUseCase.saveUser(user);
        Mockito.verify(userPersistencePort).saveUser(Mockito.any(User.class));
    }
}
