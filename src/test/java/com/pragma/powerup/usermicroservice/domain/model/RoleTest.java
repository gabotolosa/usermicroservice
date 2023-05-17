package com.pragma.powerup.usermicroservice.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    void mustGetAndSetId(){ //debe obtener y establecer id
        User user = new User();
        user.setId(1L);
        assertEquals(1L, user.getId());
    }

    @Test
    void mustGetAndSetName(){ //debe obtener y establecer nombre
        User user = new User();
        user.setName("ADMIN");
        assertEquals("ADMIN", user.getName());
    }
}