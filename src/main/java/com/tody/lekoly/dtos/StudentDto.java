package com.tody.lekoly.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link com.tody.lekoly.entities.Student}
 */
public class StudentDto implements Serializable {
    private final Integer id;
    @NotBlank
    private final String lastName;
    @NotBlank
    private final String firstName;
    @Email
    @NotBlank
    private final String email;
    private final List<EnrollmentDto> enrollments;

    public StudentDto(Integer id, String lastName, String firstName, String email, List<EnrollmentDto> enrollments) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.enrollments = enrollments;
    }

    public Integer getId() {
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

    public List<EnrollmentDto> getEnrollments() {
        return enrollments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto entity = (StudentDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.enrollments, entity.enrollments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, email, enrollments);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "lastName = " + lastName + ", " +
                "firstName = " + firstName + ", " +
                "email = " + email + ", " +
                "enrollments = " + enrollments + ")";
    }
}