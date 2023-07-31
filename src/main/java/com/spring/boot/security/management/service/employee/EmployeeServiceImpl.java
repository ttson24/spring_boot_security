package com.spring.boot.security.management.service.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.security.management.dao.EmployeeRepository;
import com.spring.boot.security.management.dto.employee.EmployeeDto;
import com.spring.boot.security.management.entity.employee.Employees;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository empRepo;
    
    @Override
    public List<EmployeeDto> findAll() {
	List<EmployeeDto> lstDto = new ArrayList<EmployeeDto>();
	List<Employees> lstEmp = new ArrayList<Employees>();
	lstEmp = empRepo.findAll();
	if(!lstEmp.isEmpty() && lstEmp.size()>0) {
	    lstEmp.forEach(emp->{
		EmployeeDto dto = new EmployeeDto();
		BeanUtils.copyProperties(emp, dto);
		lstDto.add(dto);
	    });
	}
	return lstDto;
    }

    @Override
    public EmployeeDto findById(int id) {
	EmployeeDto dto = new EmployeeDto();
	Optional<Employees> emp = empRepo.findById(id);
	if(!emp.isEmpty()) {
	    BeanUtils.copyProperties(emp, dto);
	}
	return dto;
    }

    @Override
    public List<EmployeeDto> findByName(String name) {
	List<EmployeeDto> lstDto = new ArrayList<EmployeeDto>();
	List<Employees> lstEmp = empRepo.findByName(name);
	if(!lstEmp.isEmpty() && lstEmp.size()>0) {
	   lstEmp.forEach(emp->{
	       EmployeeDto dto = new EmployeeDto();
	       BeanUtils.copyProperties(emp, dto);
	       lstDto.add(dto);
	   });
	}
	return lstDto;
    }

    @Override
    public void save(EmployeeDto dto) {
	Employees emp = new Employees();
	BeanUtils.copyProperties(dto, emp);
	empRepo.save(emp);
	
    }

    @Override
    public void deleteById(int id) {
	empRepo.deleteById(id);
	
    }

    @Override
    public void deleteByListId(List<Integer> lstId) {
	empRepo.deleteAllByIdInBatch(lstId);
	
    }

    @Override
    public EmployeeDto update(EmployeeDto dto, int id) {
	
	return null;
    }

}
