package com.example.demo.controller.exceptionHandler;

import com.example.demo.exception.NamedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class HandlerController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<NamedException> handleInvalidFormatException(Exception e) {
        return getResponseEntity("I'm teapot", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<NamedException> handleEntityNotFoundException(EntityNotFoundException e) {
        return getResponseEntity(e.getClass().getName(), e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<NamedException> handleValidationException(MethodArgumentNotValidException e) {
        final List<ValidationErrorResponse> violations = e.getBindingResult().getFieldErrors().stream()
                .map(error -> new ValidationErrorResponse(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        return getResponseEntity(e.getClass().getName(), violations.toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<NamedException> handleValidationConstraintException(ConstraintViolationException e) {
        final List<ValidationErrorResponse> violations = e.getConstraintViolations().stream()
                .map(
                        violation -> new ValidationErrorResponse(
                                violation.getPropertyPath().toString(),
                                violation.getMessage()
                        )
                )
                .collect(Collectors.toList());
        return getResponseEntity(e.getClass().getName(), violations.toString(), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<NamedException> getResponseEntity(String error, String message, HttpStatus status) {
        return new ResponseEntity<>(new NamedException(status.value(), error, message), status);
    }
}
