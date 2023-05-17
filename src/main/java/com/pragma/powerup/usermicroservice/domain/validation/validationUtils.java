package com.pragma.powerup.usermicroservice.domain.validation;

import com.pragma.powerup.usermicroservice.domain.exceptions.DomainException;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;


import static org.apache.commons.lang3.StringUtils.length;

public class validationUtils {

    public validationUtils() {
    }

    public static <T> T requiredNonNull(T obj, String field){ //generic
        if(obj == null){
            throw new DomainException(field + " should not be null");
        }
        return obj;
    }

    private static Boolean isBlank(final CharSequence cs){
        final int strLen = length(cs);
        if (strLen == 0){
            return true;
        }
        for (int i =0; i < strLen; i++){
            if(!Character.isWhitespace(cs.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void requiredNonBlank(String s, String field){
        if (isBlank(s)){
            throw new DomainException(field + " should not be blank");
        }
    }

    public static void requiredValidDni(String s, String field){
        if (!isNumeric(s)){
            throw new DomainException(field + " should be numeric dni");
        }
    }

    public static void requiredValidAge(String s, String field){
        if (!isAdult(s)){
            throw new DomainException(field + " should be > +18");
        }
    }



    public static void requiredValidPhone(String s, String field){
        if (!validPhone(s)){
            throw new DomainException(field + " should be valid phone number, may contain '+' character");
        }
    }

    public static boolean isNumeric(String dniNumber){
        String regex = "\\d+";
        return dniNumber.matches(regex);
    }


    private static Boolean isAdult(String birthdate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(birthdate, formatter);
        if (birthdate == null) {
            return false;
        }
        LocalDate now = LocalDate.now();
        Period age = Period.between(date, now);
        return age.getYears() >= 18;
    }

    public static Boolean validPhone(String phone){
        String regex = "^\\+?[0-9]{5,13}$";
        return phone.matches(regex);
    }
}
