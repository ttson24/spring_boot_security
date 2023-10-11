package com.spring.boot.security.management.service.course;

import com.spring.boot.security.management.dto.course.CourseDto;

import java.util.List;

public interface CourseService {

    List<CourseDto> findAll();

    boolean save(CourseDto dto, Long id);

    CourseDto findById(Long id);

    boolean deleteById(Long id);

    List<CourseDto> findCourseWithInstructorId(Long id);


}
