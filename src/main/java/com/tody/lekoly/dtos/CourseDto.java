package com.tody.lekoly.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.util.Objects;


public class CourseDto implements Serializable {
    private final Long id;
    @NotBlank
    private final String name;
    private final String description;
    @NotBlank
    private final String code;
    @NotNull
    @Positive
    private final Integer coefficient;
    @NotNull
    private final String status;

    public CourseDto(Long id, String name, String description, String code, Integer coefficient, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.code = code;
        this.coefficient = coefficient;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseDto entity = (CourseDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.code, entity.code) &&
                Objects.equals(this.coefficient, entity.coefficient) &&
                Objects.equals(this.status, entity.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, code, coefficient, status);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "description = " + description + ", " +
                "code = " + code + ", " +
                "coefficient = " + coefficient + ", " +
                "status = " + status + ")";
    }
}