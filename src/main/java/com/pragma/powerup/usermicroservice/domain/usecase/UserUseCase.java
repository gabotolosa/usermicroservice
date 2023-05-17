package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import com.pragma.powerup.usermicroservice.domain.validation.UserValidator;

import static com.pragma.powerup.usermicroservice.configuration.Constants.CLIENT_ROLE_ID;
import static com.pragma.powerup.usermicroservice.configuration.Constants.OWNER_ROLE_ID;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;
    Role newOwner = new Role(OWNER_ROLE_ID);
    Role newClient = new Role(CLIENT_ROLE_ID);

    public UserUseCase(IUserPersistencePort personPersistencePort) {
        this.userPersistencePort = personPersistencePort;
    }

    @Override
    public void saveUser(User user) {
        user.setRole(newClient);
        UserValidator.validateSaveUser(user);
        userPersistencePort.saveUser(user);
    }

    @Override
    public void saveOwner(User owner) {
        owner.setRole(newOwner);
        //UserValidator.validateSaveOwner(owner);
        userPersistencePort.saveOwner(owner);
    }

}
