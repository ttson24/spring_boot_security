package com.spring.boot.security.management.service.instructor;

import com.spring.boot.security.management.dto.instructor.InstructorDto;

import java.util.List;

public interface InstructorService {

    List<InstructorDto> findAll(Integer currentPage, Integer pageSize, String[] sort);

    List<InstructorDto> findAll();

    boolean save(InstructorDto instructor);

    InstructorDto findInstructorById(Long id);

    List<InstructorDto> findInstructorByName(String firstName, String lastName);

    List<InstructorDto> findInstructorByFirstName(String firstName);

    List<InstructorDto> findInstructorByLastName(String lastName);

    List<InstructorDto> findInstructorByEmail(String email);

    boolean deleteById(Long id);

}
