package com.tody.lekoly.user.entity;

import com.tody.lekoly.enrollment.entity.Enrollment;
import com.tody.lekoly.course.entity.VideoProgress;
import com.tody.lekoly.payment.entity.Payment;
import com.tody.lekoly.review.entity.Opinion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student extends User {

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "firstname")
    private String fistName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VideoProgress> videoProgresses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "student", orphanRemoval = true)
    private Set<Enrollment> enrollments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "student")
    private Set<Payment> payments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Opinion> opinions = new LinkedHashSet<>();

}