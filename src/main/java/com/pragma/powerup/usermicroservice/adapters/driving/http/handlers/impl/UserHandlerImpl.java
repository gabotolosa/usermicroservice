package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IUserRequestMapper;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IUserResponseMapper;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.pragma.powerup.usermicroservice.configuration.Constants.ADMIN_ROLE_ID;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements IUserHandler {
    private final IUserServicePort personServicePort;
    private final IUserRequestMapper personRequestMapper;
    private final IUserResponseMapper personResponseMapper;

    @Override
    public void saveUser(UserRequestDto userRequestDto) {
        personServicePort.saveUser(personRequestMapper.toUser(userRequestDto));
    }

    @Override
    public void saveOwner(UserRequestDto userRequestDto) {
        personServicePort.saveOwner(personRequestMapper.toUser(userRequestDto));
    }
}
