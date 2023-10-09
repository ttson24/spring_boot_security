package com.spring.boot.security.management.dto.course;

import com.spring.boot.security.management.entity.Instructor;
import lombok.Data;

@Data
public class CourseDto {
    private Long id;
    private String title;
    private Instructor instructor;

    public CourseDto() {
    }
}
