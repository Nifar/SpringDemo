package com.example.demo.service.validator.annotation;

import com.example.demo.service.validator.CatNameDtoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = CatNameDtoValidator.class)
@Documented
public @interface AnnotationCatNameValidator {
    String message() default "This name already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
