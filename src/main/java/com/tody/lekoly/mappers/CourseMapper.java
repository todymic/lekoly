package com.tody.lekoly.mappers;

import com.tody.lekoly.dtos.CourseDto;
import com.tody.lekoly.entities.Course;
import org.mapstruct.*;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface CourseMapper {

    CourseDto toDto(Course course);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Course partialUpdate(CourseDto courseDto, @MappingTarget Course course);

    Course toEntity(CourseDto courseDto);

}