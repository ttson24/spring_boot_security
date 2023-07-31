package com.spring.boot.security.management.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boot.security.management.common.MyConstantScreen;
import com.spring.boot.security.management.dto.employee.EmployeeDto;
import com.spring.boot.security.management.service.employee.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<EmployeeDto> lstEmp = new ArrayList<EmployeeDto>();
    
    @Autowired
    private EmployeeService empSv;
    
    @GetMapping("/")
    public String findAll(Model model){
	lstEmp = empSv.findAll();
	model.addAttribute("employees", lstEmp);
	return MyConstantScreen.EMPLOYEE_LIST;
    }
    
    @GetMapping("/emp-add")
    public String add(Model model) {
	model.addAttribute("employee", new EmployeeDto());
	return MyConstantScreen.EMPLOYEE_ADD;
    }
    
    @PostMapping("/emp-add")
    public String add(Model model, @ModelAttribute EmployeeDto emp) {
	empSv.save(emp);
	return MyConstantScreen.EMPLOYEE_LIST;
    }
    
    @GetMapping("/emp-edit")
    public String edit(Model model, @RequestParam("id") int id) {
	EmployeeDto findEmp = empSv.findById(id);
	model.addAttribute("employee", findEmp);
	return MyConstantScreen.EMPLOYEE_EDIT;
    }
    @PutMapping("/emp-edit")
    public String edit(Model model, @ModelAttribute EmployeeDto emp) {
	
	return MyConstantScreen.EMPLOYEE_LIST;
    }
}
