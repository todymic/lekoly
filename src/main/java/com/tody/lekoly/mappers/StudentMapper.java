package com.tody.lekoly.mappers;

import com.tody.lekoly.dtos.StudentDto;
import com.tody.lekoly.entities.Student;
import org.mapstruct.*;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = { CourseMapper.class }
)
public interface StudentMapper {
    Student toEntity(StudentDto studentDto);

    @AfterMapping
    default void linkEnrollments(@MappingTarget Student student) {
        student.getEnrollments().forEach(enrollment -> enrollment.setStudent(student));
    }

    StudentDto toDto(Student student);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Student partialUpdate(StudentDto studentDto, @MappingTarget Student student);
}