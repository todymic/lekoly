package com.tody.lekoly.course.enums.converter;

import com.tody.lekoly.course.enums.CourseStatusEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CourseStatusConverter implements AttributeConverter<CourseStatusEnum, String> {

    @Override
    public String convertToDatabaseColumn(CourseStatusEnum courseStatusEnum) {

        if(courseStatusEnum == null) {
            return null;
        }

        return courseStatusEnum.getStatus();
    }

    @Override
    public CourseStatusEnum convertToEntityAttribute(String status) {
        if(status == null) {
            return null;
        }
        return CourseStatusEnum.getEnumFromStatus(status);
    }
}
