package com.tody.lekoly.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank
    @Column(name = "lastname", nullable = false)
    private String lastName;

    @NotBlank
    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(unique = true)
    @Email
    @NotBlank
    private String email;

    @OneToMany(mappedBy = "student", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Enrollment> enrollments = new ArrayList<>();

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments.clear();
        enrollments.forEach(this::addEnrollment);
    }

    public void addEnrollment(Enrollment enrollment) {
        if(enrollment == null) {
            return;
        }

        enrollment.setStudent(this);

        this.enrollments.add(enrollment);
    }

    public void remove(Enrollment enrollment) {
        this.enrollments.remove(enrollment);
        enrollment.setStudent(null);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}