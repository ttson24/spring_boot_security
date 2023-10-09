package com.spring.boot.security.management.dto.instructor;

import com.spring.boot.security.management.dto.instructorDetail.InstructorDetailDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class InstructorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private InstructorDetailDto instructorDetail;

    public InstructorDto(){}
}
