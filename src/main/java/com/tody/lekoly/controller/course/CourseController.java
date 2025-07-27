package com.tody.lekoly.controller.course;

import com.tody.lekoly.dtos.CourseDto;
import com.tody.lekoly.entities.Course;
import com.tody.lekoly.services.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
class CourseController {

    private static final Log log = LogFactory.getLog(CourseController.class);
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/new")
    public CourseDto newCourse(@RequestBody @Valid CourseDto courseDto) {
        System.out.println("=== DUMP COURSE DTO ===");
        System.out.println(courseDto.getCode());
        System.out.println("=======================");

        return this.courseService.createCourse(courseDto);
    }

    @GetMapping("/list")
    public List<CourseDto> listAll() {
        return this.courseService.getAllCourses();
    }

    @GetMapping("/{code}")
    public List<CourseDto> findByCode(@PathVariable @NotNull @Valid String code) {
        return this.courseService.findByCode(code);
    }
}
