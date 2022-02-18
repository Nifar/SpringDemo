package com.example.demo.exception;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Base exception
 */
@Data
public class NamedException {

    private final LocalDateTime timestamp;

    private final Integer status;

    private final String error;

    private final String message;

    public NamedException(Integer status, String error, String message) {
        super();
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
    }

}