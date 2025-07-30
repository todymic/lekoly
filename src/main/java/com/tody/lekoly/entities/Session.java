package com.tody.lekoly.entities;

import com.tody.lekoly.enums.SessionStatusEnum;
import com.tody.lekoly.enums.converter.SessionStatusAttributeConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "session", indexes = {
        @Index(name = "idx_session_enddate", columnList = "endDate"),
        @Index(name = "idx_session_startdate", columnList = "startDate")
})
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String description;

    @FutureOrPresent
    @NotNull
    private Date startDate;

    private Date endDate;

    @Convert(converter = SessionStatusAttributeConverter.class)
    private SessionStatusEnum status;

    private Integer capacity;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Course course;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH}, optional = false)
    private Instructor instructor;

    @OneToMany(mappedBy = "session", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private Set<Enrollment> enrollments = new LinkedHashSet<>();


}