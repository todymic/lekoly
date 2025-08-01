package com.tody.lekoly.course.dto;

import com.tody.lekoly.course.enums.CourseStatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDto implements Serializable {

    Long id;
    @NotNull @NotBlank String title;
    String description;
    @NotNull Float price;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    CourseStatusEnum status;
    @NotNull
    String image;
}