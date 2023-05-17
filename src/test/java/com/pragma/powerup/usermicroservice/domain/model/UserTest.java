package com.pragma.powerup.usermicroservice.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    @Test
    void mustGetAndSetId(){ //debe obtener y establecer id
        User user = new User();
        user.setId(1L);
        assertEquals(1L, user.getId());
    }

    @Test
    void mustGetAndSetName(){ //debe obtener y establecer nombre
        User user = new User();
        user.setName("jesus");
        assertEquals("jesus", user.getName());
    }

    @Test
    void mustGetAndSetSurname(){ //debe obtener y establecer apellido
        User user = new User();
        user.setSurname("tolo");
        assertEquals("tolo", user.getSurname());
    }

    @Test
    void mustGetAndSetDniNumber(){ // obtener y establecer Dni
        User user = new User();
        user.setDniNumber("123456");
        assertEquals("123456", user.getDniNumber());
    }

    @Test
    void mustGetAndSetPhone(){ //debe obtener y establecer telefono
        User user = new User();
        user.setPhone("+57310310");
        assertEquals("+57310310", user.getPhone());
    }

    @Test
    void mustGetAndSetBirthdate(){ //debe obtener y establecer fecha nacimiento
        User user = new User();
        user.setBirthdate("1990-05-12");
        assertEquals("1990-05-12", user.getBirthdate());
    }

    @Test
    void mustGetAndSetMail(){ //debe obtener y establecer correo
        User user = new User();
        user.setMail("jesus@mail.com");
        assertEquals("jesus@mail.com", user.getMail());
    }

    @Test
    void mustGetAndSetPassword(){ //debe obtener y establecer fecha nacimiento
        User user = new User();
        user.setPassword("string");
        assertEquals("string", user.getPassword());
    }
}
