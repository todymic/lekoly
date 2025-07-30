package com.tody.lekoly.mappers;

import com.tody.lekoly.dtos.SessionDto;
import com.tody.lekoly.entities.*;
import org.mapstruct.*;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {EnrollmentMapper.class}
)
public interface SessionMapper {
    @Mapping(target = "instructor", ignore = true)
    @Mapping(target = "course", ignore = true)
    Session toEntity(SessionDto sessionDto);

    @AfterMapping
    default void linkEnrollments(@MappingTarget Session session) {
        if(session.getEnrollments() != null) {
            session.getEnrollments().forEach(enrollment -> enrollment.setSession(session));
        }
    }

    @InheritInverseConfiguration(name = "toEntity")
    @Mapping(target = "courseId", source = "course.id")
    @Mapping(target = "courseName", source = "course.name")
    @Mapping(target = "courseCode", source = "course.code")
    @Mapping(target = "instructorId", source = "instructor.id")
    @Mapping(target = "instructorLastName", source = "instructor.lastName")
    @Mapping(target = "instructorFirstName", source = "instructor.firstName")
    @Mapping(target = "enrollments", ignore = true)
    SessionDto toDto(Session session);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "course", ignore = true)
    @Mapping(target = "instructor", ignore = true)
    Session partialUpdate(SessionDto sessionDto, @MappingTarget Session session);
}