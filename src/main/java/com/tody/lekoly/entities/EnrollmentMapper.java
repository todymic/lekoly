package com.tody.lekoly.entities;

import com.tody.lekoly.dtos.EnrollmentDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EnrollmentMapper {
    Enrollment toEntity(EnrollmentDto enrollmentDto);

    EnrollmentDto toDto(Enrollment enrollment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Enrollment partialUpdate(EnrollmentDto enrollmentDto, @MappingTarget Enrollment enrollment);
}