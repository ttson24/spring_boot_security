package com.spring.boot.security.management.service.instructor;

import com.spring.boot.security.management.dto.instructor.InstructorDto;
import com.spring.boot.security.management.entity.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorService {

    public List<InstructorDto>findAll();
    public boolean save(InstructorDto instructor);
    public InstructorDto findInstructorById(Long id);
    List<InstructorDto> findInstructorByName(String firstName, String lastName);
    List<InstructorDto> findInstructorByFirstName(String firstName);
    List<InstructorDto> findInstructorByLastName(String lastName);
    List<InstructorDto> findInstructorByEmail(String email);
    public boolean deleteById(Long id);

}
