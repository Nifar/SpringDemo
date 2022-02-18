package com.example.demo.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CatDTO {

    private UUID id;

    private String name;

    private UUID ownerId;

}
