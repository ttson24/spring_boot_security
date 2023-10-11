package com.spring.boot.security.management.dao;

import com.spring.boot.security.management.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value = "SELECT id, title FROM course WHERE instructor_id=?", nativeQuery = true)
    List<Course> findCourseWithInstructorId(Long id);
}
