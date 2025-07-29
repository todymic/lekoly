package com.tody.lekoly.controller.course;

import com.tody.lekoly.dtos.CourseDto;
import com.tody.lekoly.services.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/courses")
class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping()
    public ResponseEntity<CourseDto> newCourse(@RequestBody @NotNull @Valid CourseDto courseDto) {

        CourseDto course = this.courseService.createCourse(courseDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(course.getId())
                .toUri();

        return ResponseEntity.created(location).body(course);
    }

    @GetMapping()
    public ResponseEntity<List<CourseDto>> listAll() {
        List<CourseDto> courseDtos = this.courseService.getAllCourses();
        return ResponseEntity.ok(courseDtos);
    }

    @GetMapping("/{code}")
    public ResponseEntity<CourseDto> findByCode(@PathVariable @NotNull @Valid String code )
    {
        CourseDto course = this.courseService.findByCode(code);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable @NotNull @Valid Long id) {
        this.courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable @NotNull @Valid Long id, @RequestBody @NotNull @Valid CourseDto courseDto) {
        CourseDto course = this.courseService.updateCourse(id, courseDto);
        return ResponseEntity.ok(course);
    }

}
