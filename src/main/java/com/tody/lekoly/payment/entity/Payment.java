package com.tody.lekoly.payment.entity;

import com.tody.lekoly.course.entity.Course;
import com.tody.lekoly.payment.enums.PaymentProviderEnum;
import com.tody.lekoly.payment.enums.PaymentStatusEnum;
import com.tody.lekoly.user.entity.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id")
    private Course course;

    private BigDecimal amount;

    private PaymentStatusEnum status;

    private LocalDateTime paymentDate;

    private PaymentProviderEnum provider;

}