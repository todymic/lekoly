package com.tody.lekoly.course.service;

import com.tody.lekoly.common.exceptions.ResourceNotFoundException;
import com.tody.lekoly.course.dto.CourseDto;
import com.tody.lekoly.course.entity.Course;
import com.tody.lekoly.course.mapper.CourseMapper;
import com.tody.lekoly.course.repository.CourseRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

@Service
public class CrudCourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    CrudCourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public CourseDto create(@NotNull @Valid CourseDto courseDto) {
        Course mappedCourse = this.courseMapper.toEntity(courseDto);

        Course newCourse = this.courseRepository.save(mappedCourse);

        return this.courseMapper.toDto(newCourse);
    }

    public CourseDto findById(@NotNull @Valid Long courseId) {

        Course course = this.courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException(" Course with ID :: " + courseId + " not found"));

        return this.courseMapper.toDto(course);
    }
}
