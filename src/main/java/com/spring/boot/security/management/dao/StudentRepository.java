package com.spring.boot.security.management.dao;

import com.spring.boot.security.management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT stu FROM student stu" +
            " JOIN FETCH stu.courses" +
            " WHERE stu.id=:id")
    Student findStudentAndCourseWithStudentId(@Param("id") Long id);
}
