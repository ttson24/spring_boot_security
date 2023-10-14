package com.spring.boot.security.management.dao;

import com.spring.boot.security.management.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value = "SELECT id, title FROM course WHERE instructor_id=?", nativeQuery = true)
    List<Course> findCourseWithInstructorId(Long id);

    @Query("SELECT co FROM Course co" +
            " JOIN FETCH co.students" +
            " WHERE co.id=:id")
    Course findCourseAndStudentWithCourseId(@Param("id") Long id);
}
