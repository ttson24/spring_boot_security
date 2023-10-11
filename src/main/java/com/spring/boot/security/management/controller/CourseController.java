package com.spring.boot.security.management.controller;

import com.spring.boot.security.management.common.MyConstantScreen;
import com.spring.boot.security.management.dto.course.CourseDto;
import com.spring.boot.security.management.dto.instructor.InstructorDto;
import com.spring.boot.security.management.service.course.CourseService;
import com.spring.boot.security.management.service.instructor.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    CourseService courseSv;

    @Autowired
    InstructorService insSv;

    @GetMapping("/course")
    public String index(Model model) {
        List<CourseDto> lstDto = new ArrayList<>();
        lstDto = courseSv.findAll();
        model.addAttribute("courses", lstDto);
        return MyConstantScreen.COURSE_INDEX;
    }

    @GetMapping("/course/add")
    public String add(Model model) {
        List<InstructorDto> lstIns = insSv.findAll();
        model.addAttribute("course", new CourseDto());
        model.addAttribute("isNew", true);
        model.addAttribute("ins", lstIns);
        return MyConstantScreen.COURSE_ADD;
    }

    @PostMapping("/course/add")
    public String add(Model model, @ModelAttribute CourseDto dto) {
        boolean _result = courseSv.save(dto, null);
        model.addAttribute("msg", _result ? "Success" : "Fail");
        return MyConstantScreen.REDIRECT + "/course";
    }

    @GetMapping("/course/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        CourseDto dto = courseSv.findById(id);
        model.addAttribute("course", dto);
        return MyConstantScreen.COURSE_ADD;
    }

    @PostMapping("/course/edit/{id}")
    public String edit(Model model, @ModelAttribute CourseDto dto, @PathVariable Long id) {
        boolean _result = courseSv.save(dto, id);
        model.addAttribute("msg", _result ? "Success" : "Fail");
        return MyConstantScreen.REDIRECT + "/course";
    }

    @PostMapping("/course/del/{id}")
    public String deleteById(Model model, @PathVariable Long id) {
        boolean _result = courseSv.deleteById(id);
        model.addAttribute("msg", _result ? "Success" : "Fail");
        return MyConstantScreen.REDIRECT + "/course";
    }
}
