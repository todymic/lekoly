package com.tody.lekoly.services;

import com.tody.lekoly.dtos.CourseDto;
import com.tody.lekoly.entities.Course;
import com.tody.lekoly.exceptions.DuplicateEntityException;
import com.tody.lekoly.exceptions.ResourceNotFoundException;
import com.tody.lekoly.mappers.CourseMapper;
import com.tody.lekoly.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    public static final String ID_NOT_FOUND_MESSAGE = "Course not found for this id :: ";
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
                .toList();
    }

    public CourseDto createCourse(CourseDto courseDto) {
        Course course = courseMapper.toEntity(courseDto);

        try {
            course = courseRepository.save(course);
            return courseMapper.toDto(course);
        } catch (Exception _) {
            throw new DuplicateEntityException("Course already exists for this code :: " + course.getCode());
        }
    }

    public CourseDto findByCode(String code) {
        Course course = courseRepository.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found for this code :: " + code));
        return courseMapper.toDto(course);
    }

    public void deleteCourse(Long id) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ID_NOT_FOUND_MESSAGE + id));

        courseRepository.delete(course);
    }

    public CourseDto updateCourse(Long id, CourseDto courseDto) {
        
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ID_NOT_FOUND_MESSAGE + id));
        
        course = courseMapper.partialUpdate(courseDto, course);
        course = courseRepository.save(course);
        return courseMapper.toDto(course);
    }
}
