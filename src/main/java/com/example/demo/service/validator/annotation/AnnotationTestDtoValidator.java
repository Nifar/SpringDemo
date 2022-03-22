package com.example.demo.service.validator.annotation;

import com.example.demo.service.validator.TestDtoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = TestDtoValidator.class)
@Documented
public @interface AnnotationTestDtoValidator {
    String message() default "Values no have small letters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
