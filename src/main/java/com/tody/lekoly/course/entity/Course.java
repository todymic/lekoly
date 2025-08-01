package com.tody.lekoly.course.entity;

import com.tody.lekoly.course.enums.CourseStatusEnum;
import com.tody.lekoly.enrollment.entity.Enrollment;
import com.tody.lekoly.payment.entity.Payment;
import com.tody.lekoly.user.entity.Instructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @NotNull
    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull
    @Positive
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private CourseStatusEnum status;

    @Column(name = "image", nullable = false)
    private String image;

    @OneToMany(mappedBy = "course", orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    private Set<Section> sections = new LinkedHashSet<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<Enrollment> enrollments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "course")
    @ToString.Exclude
    private Set<Payment> payments = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        status = CourseStatusEnum.DRAFT;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }


}