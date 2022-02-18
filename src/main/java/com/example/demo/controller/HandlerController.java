package com.example.demo.controller;

import com.example.demo.exception.NamedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

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

    private ResponseEntity<NamedException> getResponseEntity(String error, String message, HttpStatus status) {
        return new ResponseEntity<>(new NamedException(status.value(), error, message), status);
    }
}
