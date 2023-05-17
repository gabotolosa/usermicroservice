package com.pragma.powerup.usermicroservice.domain.validation;

import com.pragma.powerup.usermicroservice.domain.model.User;

import static com.pragma.powerup.usermicroservice.domain.validation.validationUtils.*;

public class UserValidator {
    public UserValidator() {
    }

    public static void  validateSaveUser(final User user){
        requiredNonNull(user, "User");
        requiredNonBlank(user.getName(), "name");
        //requiredNonBlank(user.getSurname(), "surname");
        //requiredValidDni(user.getDniNumber(), "dniNumber");
        //requiredValidPhone(user.getPhone(), "phone");
        //requiredNonBlank(user.getBirthdate(), "birthdate");
        //requiredValidMail(user.getMail(), "mail");
        //requiredNonBlank(user.getPassword(), "password");
        //user.getRole().setId((long) 4L);
    }

    public static void validateSaveOwner(final User owner){
        requiredNonNull(owner, "Owner");
        requiredNonBlank(owner.getName(), "name");
        requiredNonBlank(owner.getSurname(), "surname");
        requiredValidPhone(owner.getPhone(), "phone");
        requiredValidAge(owner.getBirthdate(), "birthdate");
    }

    /*
    public static void validateLoginUser(User user){
        requiredNonNull(user, "User");
        requiredValidMail(user.getMail(), "mail");
        requiredNonBlank(user.getPassword(), "password");
    }
     */
}
