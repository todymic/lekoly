package com.tody.lekoly.user.entity;

import com.tody.lekoly.course.entity.Course;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "instructor")
public class Instructor extends User {

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Course> courses = new LinkedHashSet<>();

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

}