package com.gianpc.restapis.utils.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TitleValidator implements ConstraintValidator<TitleConstraint, String> {
    @Override
    public void initialize(TitleConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String nameField, ConstraintValidatorContext context) {
        return nameField != null && nameField.indexOf(" ") > 1; // El título debe tener al menos 2 palabras
    }

}
