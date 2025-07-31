package com.tody.lekoly.course.mapper;

import com.tody.lekoly.course.dto.CourseDto;
import com.tody.lekoly.course.entity.Course;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseMapper {
    Course toEntity(CourseDto courseDto);

    CourseDto toDto(Course course);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Course partialUpdate(CourseDto courseDto, @MappingTarget Course course);
}