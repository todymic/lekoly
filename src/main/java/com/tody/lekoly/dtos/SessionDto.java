package com.tody.lekoly.dtos;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
public class SessionDto implements Serializable {
    Long id;
    String description;
    Date startDate;
    Date endDate;
    String status;
    Integer capacity;
    Long courseId;
    String courseName;
    String courseCode;
    Long instructorId;
    String instructorLastName;
    String instructorFirstName;
    private Set<EnrollmentDto> enrollments = new HashSet<>();

}