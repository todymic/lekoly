package com.tody.lekoly.repositories;

import com.tody.lekoly.entities.Course;
import com.tody.lekoly.entities.Session;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByCode(String code);
}