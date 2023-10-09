package com.spring.boot.security.management.dto.instructorDetail;

import com.spring.boot.security.management.dto.instructor.InstructorDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class InstructorDetailDto {
    private Long id;
    private String youtubeChannel;
    private String hobby;
    public InstructorDetailDto(){}
}
