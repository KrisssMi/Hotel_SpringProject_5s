package com.example.by.minevich.validator;

import com.example.by.minevich.models.BookingForm;
import com.example.by.minevich.models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BookingValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        BookingForm room =(BookingForm)o;
        if(room.getId()<0){
            errors.rejectValue("id","negative value");
        }
    }
}
