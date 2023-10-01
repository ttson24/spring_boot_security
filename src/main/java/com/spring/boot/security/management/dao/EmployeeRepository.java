package com.spring.boot.security.management.dao;

import java.util.List;

import com.spring.boot.security.management.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EmployeeRepository extends JpaRepository<Employees, Integer>{

   @Query(value="SELECT id, first_name, last_name, email, created_at, updated_at, deleted_at "
   		+ "	FROM Employees "
   		+ "	WHERE first_name like %?% OR last_name like %?% "
   		+ "	ORDER BY id DESC",
	   nativeQuery = true)
   public List<Employees> findByName(String firstName, String lastName);

}
