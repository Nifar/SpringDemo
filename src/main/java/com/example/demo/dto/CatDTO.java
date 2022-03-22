package com.example.demo.dto;

import com.example.demo.service.validator.annotation.AnnotationCatNameValidator;
import lombok.Data;

import java.util.UUID;

@Data
public class CatDTO {

    private UUID id;

    @AnnotationCatNameValidator
    private String name;

    private UUID ownerId;

}
