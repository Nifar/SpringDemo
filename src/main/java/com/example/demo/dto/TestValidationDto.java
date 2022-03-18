package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestValidationDto {

    @Min(10)
    @Max(100)
    private int intValue;

    @Size(min = 10, max = 50)
    @NotBlank
    private String value;

    @NotNull
    @Email
    private String email;

    @Pattern(regexp = "[a-z]{5}")
    @JsonProperty("some_pattern")
    private String somePattern;

}
