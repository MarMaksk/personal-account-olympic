package com.lk.backend.validations;

import com.lk.backend.annotation.PasswordMatches;
import com.lk.backend.payload.request.SignupRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        SignupRequest user = (SignupRequest) o;
        return user.getPassword().equals(user.getConfirmPassword());
    }
}
