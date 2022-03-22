package com.example.demo.service.validator;

import com.example.demo.dto.TestValidationDto;
import com.example.demo.service.validator.annotation.AnnotationTestDtoValidator;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Service
public class TestDtoValidator implements ConstraintValidator<AnnotationTestDtoValidator, TestValidationDto> {
    @Override
    public boolean isValid(TestValidationDto testValidationDto, ConstraintValidatorContext constraintValidatorContext) {
        String dtoValue = testValidationDto.getValue();
        if (dtoValue != null && !dtoValue.isEmpty()) {
            return Character.isUpperCase(dtoValue.charAt(0));
        }
        return true;
    }
}
