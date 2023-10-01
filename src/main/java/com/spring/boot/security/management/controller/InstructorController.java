package com.spring.boot.security.management.controller;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.spring.boot.security.management.common.MyConstantScreen;
import com.spring.boot.security.management.dto.instructor.InstructorDto;
import com.spring.boot.security.management.service.instructor.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InstructorController {

    @Autowired
    private InstructorService insSv;

    @GetMapping("/ins")
    public String index(Model model){
        List<InstructorDto> _lstResult = insSv.findAll();
        model.addAttribute("ins", _lstResult);
        return MyConstantScreen.INS_INDEX;
    }

    @GetMapping("/ins/add")
    public String add(Model model){
        model.addAttribute("insDto", new InstructorDto());
        return MyConstantScreen.INS_ADD;
    }

    @PostMapping("/ins/add")
    public String add(Model model, @ModelAttribute InstructorDto dto){
        boolean _result = insSv.save(dto);
        model.addAttribute("msg", _result?"":"");
//        return MyConstantScreen.REDIRECT+"ins";
        return "";
    }

    @GetMapping("/ins/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id){
        InstructorDto dto = insSv.findInstructorById(id);
        model.addAttribute("ins", dto);
        return MyConstantScreen.INS_ADD;
    }

    @PostMapping("/ins/edit/{id}")
    public String edit(Model model, @ModelAttribute InstructorDto dto, @PathVariable("id") Long id){
        dto.setId(id);
        boolean _result = insSv.save(dto);
        model.addAttribute("msg", _result?"":"");
        return MyConstantScreen.REDIRECT+"ins";
    }

    @GetMapping("/ins/find/{name}")
    public String findInsByName(Model model, @PathVariable("name") String name){
        String _firstName = "";
        String _lastname = "";
        List<InstructorDto> _lstSearchResult = new ArrayList<>();
        String[] _names = name.split("");
        if(_names.length == 2){
            _firstName = _names[0];
            _lastname = _names[1];
            if (_firstName.isBlank()){
                _lstSearchResult = insSv.findInstructorByLastName(_lastname);
            }else{
                _lstSearchResult = insSv.findInstructorByName(_firstName, _lastname);
            }
        }else if (_names.length == 1){
            _firstName = _names[0];
            _lstSearchResult = insSv.findInstructorByFirstName(_firstName);
        }else {
            model.addAttribute("msg", "");
            model.addAttribute("ins", "");
            return MyConstantScreen.INS_INDEX;
        }
        model.addAttribute("ins", _lstSearchResult);
        return MyConstantScreen.INS_INDEX;
    }

    @GetMapping("/ins/find/{email}")
    public String findInstructorByEmail(Model model, @PathVariable("email") String email){
        List<InstructorDto> _result = insSv.findInstructorByEmail(email);
        model.addAttribute("ins", _result);
        return MyConstantScreen.INS_INDEX;
    }

    @PostMapping("/ins/delete/{id}")
    public String deleteById(Model model, @PathVariable("id") Long id){
        boolean _result = insSv.deleteById(id);
        model.addAttribute("msg", _result?"":"");
        return MyConstantScreen.REDIRECT+"ins";
    }
}
