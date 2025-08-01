package com.tody.lekoly.course.enums;

import lombok.Getter;

@Getter
public enum CourseStatusEnum {
    DRAFT("D"), PUBLISHED("P"), ARCHIVED("A"), VALIDATED("V");

    private final String status;

    CourseStatusEnum(String status) {
        this.status = status;
    }

    public static CourseStatusEnum getEnumFromStatus(String status) {
        switch (status) {
            case "D" -> {
                return CourseStatusEnum.DRAFT;
            }
            case "P" -> {
                return CourseStatusEnum.PUBLISHED;
            }
            case "A" -> {
                return CourseStatusEnum.ARCHIVED;
            }
            case "V" -> {
                return CourseStatusEnum.VALIDATED;
            }
            default -> throw new IllegalArgumentException("Status [" + status + "] nos supported.");
        }

    }
}
