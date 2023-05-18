package com.pragma.powerup.usermicroservice.factory;

import com.pragma.powerup.usermicroservice.domain.model.User;

public class UserFactoryDataTest {

    private UserFactoryDataTest(){
    }

    public static User getUser(){
        User user = new User();
        user.setId(1L);
        user.setName("keila");
        user.setSurname("war");
        user.setDniNumber("123456");
        user.setPhone("+57310315");
        user.setBirthdate("2000-01-01");
        user.setMail("keila@mail.com");
        user.setPassword("string");
        user.getRole().setId(4L);

        return user;
    }

    public static User getOwner(){
        User user = new User();
        user.setId(1L);
        user.setName("jesus");
        user.setSurname("tolo");
        user.setDniNumber("123456");
        user.setPhone("+57310315");
        user.setBirthdate("2000-01-01");
        user.setMail("jesus@mail.com");
        user.setPassword("string");
        user.getRole().setId(2L);

        return user;
    }

}
