package com.tody.lekoly.course.service;

import com.tody.lekoly.common.exceptions.ResourceNotFoundException;
import com.tody.lekoly.course.dto.CourseDto;
import com.tody.lekoly.course.entity.Course;
import com.tody.lekoly.course.mapper.CourseMapper;
import com.tody.lekoly.course.repository.CourseRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

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

        Course course = getCourse(courseId);

        return this.courseMapper.toDto(course);
    }



    public List<CourseDto> findAll() {
        List<Course> courses = this.courseRepository.findAll();

        return courses.stream()
                .map(this.courseMapper::toDto)
                .toList();
    }

    public CourseDto update(@NotNull @Valid Long courseId, @NotNull @Valid CourseDto courseDto) {

        Course course = this.getCourse(courseId);
        Course updatedCourse = this.courseMapper.partialUpdate(courseDto, course);

        Course updateCourse = this.courseRepository.save(updatedCourse);

        return this.courseMapper.toDto(updateCourse);
        
    }

    private Course getCourse(Long courseId) {
        return this.courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course with ID :: " + courseId + " not found"));
    }

    public void removeById(Long courseId) {

        this.getCourse(courseId);
        this.courseRepository.deleteById(courseId);
    }
}
