package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Transactional
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByDniNumber(String dniNumber);
    Optional<UserEntity> findByMail(String mail);

    Boolean existsByDniNumber(String dniNumber);

    boolean existsByMail(String mail);

}
