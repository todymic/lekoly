package com.tody.lekoly.controller.course;

import com.tody.lekoly.dtos.SessionDto;
import com.tody.lekoly.services.SessionCourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sessions")
class SessionController {
    private final SessionCourseService sessionCourseService;

    public SessionController(SessionCourseService sessionCourseService) {
        this.sessionCourseService = sessionCourseService;
    }
    @GetMapping("/search")
    public ResponseEntity<List<SessionDto>>search(
            @RequestParam(required = false) Date startDate,
            @RequestParam(required = false) Date endDate,
            @RequestParam(required = false) Long courseId,
            @RequestParam(required = false) Long instructorId,
            @RequestParam(required = false) String status
   ) {

       List<SessionDto> sessions = this.sessionCourseService.searchByTerm(startDate, endDate, courseId, instructorId, status);

        return ResponseEntity
                .ok(sessions);

    }

    @PostMapping()
    public ResponseEntity<SessionDto>createNew(@RequestBody @Valid @NotNull SessionDto sessionDto) {

        SessionDto session = this.sessionCourseService.create(sessionDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(session.getId())
                .toUri();


        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SessionDto> updateSession(@PathVariable(name = "id") Long sessionId, @RequestBody @Valid @NotNull SessionDto sessionDto) {
        SessionDto session = this.sessionCourseService.updateSession(sessionId, sessionDto);
        return ResponseEntity.ok(session);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSession(@PathVariable(name = "id") Long sessionId) {
        this.sessionCourseService.remove(sessionId);
        return ResponseEntity.ok(null);
    }


}
