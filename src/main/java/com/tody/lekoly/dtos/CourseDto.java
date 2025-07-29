package com.tody.lekoly.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.io.Serializable;

@Data
public class CourseDto implements Serializable {
    Long id;
    @NotBlank
    String name;
    String description;
    @NotBlank(message = "Le code ne doit pas être vide")
    String code;
    @NotNull
    @Positive
    Integer coefficient;
    @NotNull
    String status;
}