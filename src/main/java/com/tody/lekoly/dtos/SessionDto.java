package com.tody.lekoly.dtos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * DTO for {@link com.tody.lekoly.entities.Session}
 */
public class SessionDto implements Serializable {
    private final Long id;
    private final String description;
    @NotNull
    @FutureOrPresent
    private final Date startDate;
    private final Date endDate;
    private final String status;
    private final Integer capacity;
    private final CourseDto course;
    private final InstructorDto instructor;

    public SessionDto(Long id, String description, Date startDate, Date endDate, String status, Integer capacity, CourseDto course, InstructorDto instructor) {
        this.id = id;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.capacity = capacity;
        this.course = course;
        this.instructor = instructor;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public CourseDto getCourse() {
        return course;
    }

    public InstructorDto getInstructor() {
        return instructor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionDto entity = (SessionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.startDate, entity.startDate) &&
                Objects.equals(this.endDate, entity.endDate) &&
                Objects.equals(this.status, entity.status) &&
                Objects.equals(this.capacity, entity.capacity) &&
                Objects.equals(this.course, entity.course) &&
                Objects.equals(this.instructor, entity.instructor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, startDate, endDate, status, capacity, course, instructor);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "description = " + description + ", " +
                "startDate = " + startDate + ", " +
                "endDate = " + endDate + ", " +
                "status = " + status + ", " +
                "capacity = " + capacity + ", " +
                "course = " + course + ", " +
                "instructor = " + instructor + ")";
    }
}