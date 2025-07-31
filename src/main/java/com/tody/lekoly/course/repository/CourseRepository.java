package com.tody.lekoly.course.repository;

import com.tody.lekoly.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}