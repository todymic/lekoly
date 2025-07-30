package com.tody.lekoly.services;

import com.tody.lekoly.dtos.SessionDto;
import com.tody.lekoly.entities.Course;
import com.tody.lekoly.entities.Instructor;
import com.tody.lekoly.entities.InstructorRepository;
import com.tody.lekoly.entities.Session;
import com.tody.lekoly.exceptions.ResourceNotFoundException;
import com.tody.lekoly.mappers.SessionMapper;
import com.tody.lekoly.repositories.CourseRepository;
import com.tody.lekoly.repositories.SessionRepository;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SessionCourseService {

    private static final Logger logger = LoggerFactory.getLogger(SessionCourseService.class);
    private final SessionMapper sessionMapper;
    private final SessionRepository sessionRepository;
    private final EntityManager entityManager;
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;


    public SessionCourseService(SessionMapper sessionMapper, SessionRepository sessionRepository, EntityManager entityManager, CourseRepository courseRepository, InstructorRepository instructorRepository) {
        this.sessionMapper = sessionMapper;
        this.sessionRepository = sessionRepository;
        this.entityManager = entityManager;
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
    }

    public List<SessionDto> searchByTerm(Date startDate,
                                         Date endDate,
                                         Long courseId,
                                         Long instructorId,
                                         String status)
    {


        List<Session> sessionsCourse = this.sessionRepository.findByCriteria(
                startDate,
                endDate,
                courseId,
                instructorId,
                status
        );

        return sessionsCourse.stream()
                .map(sessionMapper::toDto)
                .toList();
    }

    public SessionDto create(SessionDto sessionDto) {
        logger.info("DTO startDate: {}", sessionDto.getStartDate());
        Session session = sessionMapper.toEntity(sessionDto);

        this.hydrateSessionCourse(session, sessionDto.getCourseId());
        this.hydrateSessionInstructor(session, sessionDto.getInstructorId());

        session = this.sessionRepository.save(session);


        return sessionMapper.toDto(session);
    }

    public SessionDto updateSession(Long sessionId, SessionDto sessionDto) {

        Session session = this.findSessionById(sessionId);

        if(sessionDto.getCourseId() != null) {
            this.hydrateSessionCourse(session, sessionDto.getCourseId());
        }

        if(sessionDto.getInstructorId() != null) {
            this.hydrateSessionInstructor(session, sessionDto.getInstructorId());
        }

        Session mappedSession = sessionMapper.partialUpdate(sessionDto, session);
        Session updatedSession = this.sessionRepository.save(mappedSession);

        return sessionMapper.toDto(updatedSession);
    }

    protected void hydrateSessionCourse(Session session, @Valid @NotNull  Long courseId) {
        if(!this.courseRepository.existsById(courseId)) {
            throw new ResourceNotFoundException("Course with ID :: " + courseId + " not found");
        }
        Course course = this.entityManager.getReference(Course.class, courseId);
        session.setCourse(course);
    }

    protected void hydrateSessionInstructor(Session session, @Valid @NotNull Long instructorId) {

        if(!this.instructorRepository.existsById(instructorId)) {
            throw new ResourceNotFoundException("Instructor with ID :: " + instructorId + " not found");
        }

        Instructor instructor = this.entityManager.getReference(Instructor.class, instructorId);
        session.setInstructor(instructor);
    }

    public void remove(Long sessionId) {
        Session session = this.findSessionById(sessionId);
        this.sessionRepository.delete(session);

        logger.info("Session with ID :: {} removed !!", sessionId);
    }

    private Session findSessionById(Long sessionId) {
        return this.sessionRepository.findById(sessionId)
                .orElseThrow(() -> new ResourceNotFoundException(" Session with ID :: " + sessionId + " not found"));
    }
}
