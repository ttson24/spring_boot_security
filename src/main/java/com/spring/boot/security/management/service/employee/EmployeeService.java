package com.spring.boot.security.management.service.employee;

import java.util.List;

import com.spring.boot.security.management.dto.employee.EmployeeDto;

public interface EmployeeService {

    public List<EmployeeDto> findAll();
    
    public EmployeeDto findById(Integer id);
    
    public List<EmployeeDto> findByName(String name);
    
    public void save(EmployeeDto dto);
    
    public void update(EmployeeDto dto);
    
    public void deleteById(Integer id);
    
    public void deleteByListId(List<Integer> lstId);
}
