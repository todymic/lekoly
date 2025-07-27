package com.tody.lekoly.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.tody.lekoly.entities.Instructor}
 */
public class InstructorDto implements Serializable {
    private final Long id;
    @NotNull
    @NotBlank
    private final String lastName;
    @NotNull
    @NotBlank
    private final String firstName;
    @NotNull
    @Email
    @NotBlank
    private final String email;
    @NotNull
    @NotBlank
    private final String speciality;

    public InstructorDto(Long id, String lastName, String firstName, String email, String speciality) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.speciality = speciality;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getSpeciality() {
        return speciality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstructorDto entity = (InstructorDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.speciality, entity.speciality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, email, speciality);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "lastName = " + lastName + ", " +
                "firstName = " + firstName + ", " +
                "email = " + email + ", " +
                "speciality = " + speciality + ")";
    }
}