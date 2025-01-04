package com.gianpc.restapis.utils.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TitleValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TitleConstraint {
    String message() default "Invalid title";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
