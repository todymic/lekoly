package com.tody.lekoly.course.controller;

import com.tody.lekoly.course.dto.CourseDto;
import com.tody.lekoly.course.service.CrudCourseService;
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

    private final CrudCourseService crudCourseService;

    CourseController(CrudCourseService crudCourseService) {
        this.crudCourseService = crudCourseService;
    }

    @PostMapping()
    public ResponseEntity<CourseDto> create(@RequestBody @NotNull @Valid CourseDto courseDto) {

        CourseDto course = this.crudCourseService.create(courseDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(course)
                .toUri();

        return ResponseEntity.created(location)
                .body(course);
    }

    @GetMapping("/{id}")
    public CourseDto findCourse(@PathVariable(name = "id") @NotNull @Valid Long courseId) {
        return this.crudCourseService.findById(courseId);
    }

    @GetMapping()
    public ResponseEntity<List<CourseDto>> findAll() {

        List<CourseDto> courses = this.crudCourseService.findAll();

        return ResponseEntity.ok(courses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> update(@PathVariable(name = "id") @NotNull @Valid Long courseId, @RequestBody @NotNull @Valid CourseDto courseDto) {
        CourseDto course = this.crudCourseService.update(courseId, courseDto);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") @NotNull @Valid Long courseId) {

        this.crudCourseService.removeById(courseId);
        return ResponseEntity.noContent().build();

    }
}
