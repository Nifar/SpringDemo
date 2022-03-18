package com.example.demo.controller.exceptionHandler;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ValidationErrorResponse {
    private String fieldName;
    private String message;

    @Override
    public String toString() {
        return "field_name='" + fieldName + '\'' +
                ", message='" + message + '\'';
    }
}