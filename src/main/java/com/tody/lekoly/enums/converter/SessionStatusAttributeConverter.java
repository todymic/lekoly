package com.tody.lekoly.enums.converter;

import com.tody.lekoly.enums.SessionStatusEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class SessionStatusAttributeConverter implements AttributeConverter<SessionStatusEnum, String> {

    @Override
    public String convertToDatabaseColumn(SessionStatusEnum sessionStatusEnum) {
        if(sessionStatusEnum == null) {
            return null;
        }

        return sessionStatusEnum.getStatus();
    }

    @Override
    public SessionStatusEnum convertToEntityAttribute(String statusDBValue) {

        if(statusDBValue == null) {
            return null;
        }

        return Stream.of(SessionStatusEnum.values())
                .filter(statusEnum -> statusEnum.getStatus().equals(statusDBValue))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
