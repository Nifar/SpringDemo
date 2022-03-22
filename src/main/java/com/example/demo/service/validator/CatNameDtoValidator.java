package com.example.demo.service.validator;

import com.example.demo.service.CatService;
import com.example.demo.service.validator.annotation.AnnotationCatNameValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Service
@RequiredArgsConstructor
public class CatNameDtoValidator implements ConstraintValidator<AnnotationCatNameValidator, String> {

    private final CatService catService;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !catService.catExists(s);
    }
}
