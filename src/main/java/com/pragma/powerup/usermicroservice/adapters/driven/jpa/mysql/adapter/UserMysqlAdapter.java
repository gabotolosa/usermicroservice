package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.MailAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.PersonAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IUserEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IUserRepository;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import io.micrometer.observation.Observation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.pragma.powerup.usermicroservice.configuration.Constants.ADMIN_ROLE_ID;
import static com.pragma.powerup.usermicroservice.configuration.Constants.OWNER_ROLE_ID;

@RequiredArgsConstructor
public class UserMysqlAdapter implements IUserPersistencePort {
    private final IUserRepository personRepository;
    private final IUserEntityMapper personEntityMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void saveUser(User user) {
        if (personRepository.findByMail(user.getMail()).isPresent()) {
            throw new PersonAlreadyExistsException();
        }

        if (personRepository.existsByMail(user.getMail())){
            throw new MailAlreadyExistsException();
        }
        //user.getRole().setId(OWNER_ROLE_ID);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        personRepository.save(personEntityMapper.toEntity(user));

    }

    @Override
    public void saveOwner(User owner) {
        if (personRepository.findByMail(owner.getMail()).isPresent()) {
            throw new PersonAlreadyExistsException();
        }

        if (personRepository.existsByMail(owner.getMail())){
            throw new MailAlreadyExistsException();
        }
        //user.getRole().setId(OWNER_ROLE_ID);
        owner.setPassword(passwordEncoder.encode(owner.getPassword()));
        personRepository.save(personEntityMapper.toEntity(owner));
    }
}
