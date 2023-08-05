package com.spring.boot.security.management.service.employee;

import java.util.List;

import com.spring.boot.security.management.dto.employee.EmployeeDto;

public interface EmployeeService {

    public List<EmployeeDto> findAll();
    
    public EmployeeDto findById(int id);
    
    public List<EmployeeDto> findByName(String name);
    
    public void save(EmployeeDto dto);
    
    public void update(EmployeeDto dto);
    
    public void deleteById(int id);
    
    public void deleteByListId(List<Integer> lstId);
}
