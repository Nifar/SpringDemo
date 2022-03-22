package com.example.demo.controller;

import com.example.demo.dto.TestValidationDto;
import com.example.demo.exception.NamedException;
import com.example.demo.service.validator.annotation.AnnotationTestDtoValidator;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

@RestController
@RequestMapping("api/test")
@Validated
public class TestValidationController {

    @PostMapping("dtoValidate")
    public TestValidationDto validationDtoTest(@RequestBody @AnnotationTestDtoValidator(message = "this is new costume message") @Valid TestValidationDto dto) {
        return dto;
    }

    @GetMapping
    public ResponseEntity<NamedException> handleInvalidFormatException() {
        return getResponseEntity("I'm teapot", "e.getMessage()", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<NamedException> getResponseEntity(String error, String message, HttpStatus status) {
        return new ResponseEntity<>(new NamedException(status.value(), error, message), status);
    }

    @GetMapping("valuesValidate")
    public Object validateSomeValuesTest(@RequestParam @Size(max = 10) @NotBlank String firstValue, @RequestParam @Min(5) @Max(25) int secondValue, @RequestParam @Email @NotBlank String emailValue) {
        return new Object() {
            @Getter
            private String fValue = firstValue;
            @Getter
            private int sValue = secondValue;
            @Getter
            private String email = emailValue;
        };
    }

}
