package com.spring.boot.security.management.service.instructor;

import com.spring.boot.security.management.dao.InstructorRepository;
import com.spring.boot.security.management.dto.instructor.InstructorDto;
import com.spring.boot.security.management.entity.Instructor;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    InstructorRepository insRepo;

    @Override
    public List<InstructorDto> findAll() {
        List<InstructorDto> lstInsReturn = new ArrayList<>();
        List<Instructor> lstInstructor = new ArrayList<>();
        lstInstructor = insRepo.findAll();
        if (!lstInstructor.isEmpty() & lstInstructor.size()>0){
            lstInstructor.forEach(ins->{
                InstructorDto dto = new InstructorDto();
                BeanUtils.copyProperties(ins,dto);
                lstInsReturn.add(dto);
            });
        }
        return lstInsReturn;
    }

    @Override
    @Transactional
    public boolean save(InstructorDto instructor) {
        boolean _result = true;
        try{
            Instructor ins = new Instructor();
            BeanUtils.copyProperties(instructor, ins);
            insRepo.save(ins);
        }catch (Exception ex){
            _result = false;
        }
        return _result;
    }

    @Override
    public InstructorDto findInstructorById(Long id) {
        Optional<Instructor> ins = insRepo.findById(id);
        InstructorDto dto = new InstructorDto();
        BeanUtils.copyProperties(ins, dto);
        return dto;
    }

    @Override
    public List<InstructorDto> findInstructorByName(String firstName, String lastName) {
        List<Instructor> lstIns = new ArrayList<>();
        List<InstructorDto>lstDto = new ArrayList<>();
        lstIns = insRepo.findInstructorByName(firstName, lastName);
        if (!lstIns.isEmpty() & lstIns.size()>0){
            lstIns.forEach(ins->{
                InstructorDto dto = new InstructorDto();
                BeanUtils.copyProperties(ins,dto);
                lstDto.add(dto);
            });
        }
        return lstDto;
    }

    @Override
    public List<InstructorDto> findInstructorByFirstName(String firstName) {
        List<InstructorDto> lstDto = new ArrayList<>();
        List<Instructor> lstIns = insRepo.findInstructorByFirstName(firstName);
        if (!lstIns.isEmpty() & lstIns.size()>0){
            lstIns.forEach(ins->{
                InstructorDto dto = new InstructorDto();
                BeanUtils.copyProperties(ins, dto);
                lstDto.add(dto);
            });

        }
        return lstDto;
    }

    @Override
    public List<InstructorDto> findInstructorByLastName(String lastName) {
        List<InstructorDto> lstDto = new ArrayList<>();
        List<Instructor> lstIns = insRepo.findInstructorByLastName(lastName);
        if (!lstIns.isEmpty() & lstIns.size()>0){
            lstIns.forEach(ins->{
                InstructorDto dto = new InstructorDto();
                BeanUtils.copyProperties(ins, dto);
                lstDto.add(dto);
            });
        }
        return lstDto;
    }

    @Override
    public List<InstructorDto> findInstructorByEmail(String email) {
        List<InstructorDto> lstDto = new ArrayList<>();
        List<Instructor> lstIns = insRepo.findInstructorByEmail(email);
        if (!lstIns.isEmpty() & lstIns.size()>0){
            lstIns.forEach(ins->{
                InstructorDto dto = new InstructorDto();
                BeanUtils.copyProperties(ins, dto);
                lstDto.add(dto);
            });
        }
        return lstDto;
    }

    @Override
    public boolean deleteById(Long id) {
        boolean _result = true;
        try{
            insRepo.deleteById(id);
        }catch (Exception ex){
            _result = false;
        }
        return _result;
    }
}
