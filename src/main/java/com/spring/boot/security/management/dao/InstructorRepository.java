package com.spring.boot.security.management.dao;

import com.spring.boot.security.management.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    @Query(value = "SELECT id, first_name, last_name, email, hobby" +
            "   FROM instructor " +
            "   WHERE first_name like %?% OR last_name like %?% " +
            "   ORDER BY id DESC", nativeQuery = true)
    List<Instructor> findInstructorByName(String firstName, String lastName);

    @Query(value = "SELECT id, first_name, last_name, email, hobby" +
            " FROM instructor " +
            " WHERE first_name=? " +
            " ORDER BY id DESC", nativeQuery = true)
    List<Instructor> findInstructorByFirstName(String firstName);

    @Query(value = "SELECT id, first_name, last_name, email, hobby" +
            " FROM instructor " +
            " WHERE last_name=?" +
            " ORDER BY id DESC"
            , nativeQuery = true)
    List<Instructor> findInstructorByLastName(String lastName);

    @Query(value = "SELECT id, first_name, last_name, email, hobby" +
            " FROM instructor " +
            " WHERE email=?" +
            " ORDER BY id DESC"
            , nativeQuery = true)
    List<Instructor> findInstructorByEmail(String email);

    @Query(value = "SELECT ins FROM Instructor ins " +
            " JOIN FETCH ins.courses " +
            " JOIN FETCH ins.instructorDetail" +
            " WHERE ins.id = :id")
    List<Instructor> findInstructorByJoinFetch(@Param("id") Long id);
}
