package com.tody.lekoly.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "course", indexes = {
        @Index(name = "idx_course_code", columnList = "code"),
        @Index(name = "idx_course_name", columnList = "name")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uc_course_code", columnNames = {"code"})
})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    private String name;

    private String description;

    @NotBlank(message = "Le code ne doit pas être vide")
    @Column(unique = true)
    @NaturalId
    private String code;

    @NotNull
    @Positive
    private Integer coefficient;

    @NotNull
    private String status;

    @OneToMany(mappedBy = "course", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private Set<Session> sessions = new LinkedHashSet<>();

    public Course(String code) {
        this.code = code;
    }

    public Course() {

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) && Objects.equals(name, course.name) && Objects.equals(description, course.description) && Objects.equals(code, course.code) && Objects.equals(coefficient, course.coefficient) && Objects.equals(status, course.status) && Objects.equals(sessions, course.sessions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, code, coefficient, status, sessions);
    }
}

