package com.tody.lekoly.services;

import com.tody.lekoly.dtos.CourseDto;
import com.tody.lekoly.entities.Course;
import com.tody.lekoly.mappers.CourseMapper;
import com.tody.lekoly.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    public final CourseRepository courseRepository;
    public final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }

    public CourseDto createCourse(CourseDto courseDto) {
        Course course = courseMapper.toEntity(courseDto);
        course = courseRepository.save(course);
        return courseMapper.toDto(course);
    }

    public List<CourseDto> findByCode(String code) {
        List<Course> courses = courseRepository.findByCode(code);
        return courses.stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());

    }
}
