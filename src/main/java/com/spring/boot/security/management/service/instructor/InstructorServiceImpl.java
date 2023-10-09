package com.spring.boot.security.management.service.instructor;

import com.spring.boot.security.management.dao.InstructorRepository;
import com.spring.boot.security.management.dto.instructor.InstructorDto;
import com.spring.boot.security.management.dto.instructorDetail.InstructorDetailDto;
import com.spring.boot.security.management.entity.Instructor;
import com.spring.boot.security.management.entity.InstructorDetail;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    InstructorRepository insRepo;

    @Override
    public List<InstructorDto> findAll(Integer currentPage, Integer pageSize, String[] sort) {
        List<InstructorDto> lstInsReturn = new ArrayList<>();
        List<Instructor> lstInstructor = new ArrayList<>();

        String sortField = sort[0];
        String sortDirection = sort[1];

        Direction direction = sortDirection.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Order order = new Order(direction, sortField);

        Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by(order));

        lstInstructor = (List<Instructor>) insRepo.findAll(pageable);

        if (!lstInstructor.isEmpty() & lstInstructor.size() > 0) {
            lstInstructor.forEach(ins -> {
                InstructorDto dto = new InstructorDto();
                InstructorDetailDto dtoDetail = new InstructorDetailDto();
                BeanUtils.copyProperties(ins, dto);
                BeanUtils.copyProperties(ins.getInstructorDetail(), dtoDetail);
                dto.setInstructorDetail(dtoDetail);
                lstInsReturn.add(dto);
            });
        }
        return lstInsReturn;
    }

    public List<InstructorDto> findAll() {
        List<InstructorDto> lstInsReturn = new ArrayList<>();
        List<Instructor> lstInstructor = new ArrayList<>();

        lstInstructor = insRepo.findAll();

        if (!lstInstructor.isEmpty() & lstInstructor.size() > 0) {
            lstInstructor.forEach(ins -> {
                InstructorDto dto = new InstructorDto();
                InstructorDetailDto dtoDetail = new InstructorDetailDto();
                BeanUtils.copyProperties(ins, dto);
                BeanUtils.copyProperties(ins.getInstructorDetail(), dtoDetail);
                dto.setInstructorDetail(dtoDetail);
                lstInsReturn.add(dto);
            });
        }
        return lstInsReturn;
    }

    @Override
    @Transactional
    public boolean save(InstructorDto dto) {
        boolean _result = true;
        try {
            InstructorDetail insDetail = new InstructorDetail();
            if (null == dto.getId()) {
                Instructor ins = new Instructor();
                BeanUtils.copyProperties(dto, ins);
                insDetail.setYoutubeChannel(dto.getInstructorDetail().getYoutubeChannel());
                insDetail.setHobby(dto.getInstructorDetail().getHobby());
                ins.setInstructorDetail(insDetail);
                insRepo.save(ins);
            } else {
                Optional<Instructor> upIns = insRepo.findById(dto.getId());
                if (upIns.isPresent()) {
                    insDetail.setId(upIns.get().getInstructorDetail().getId());
                    insDetail.setYoutubeChannel(upIns.get().getInstructorDetail().getYoutubeChannel());
                    insDetail.setHobby(upIns.get().getInstructorDetail().getHobby());
                    Instructor data = new Instructor(
                            upIns.get().getId(),
                            upIns.get().getFirstName(),
                            upIns.get().getLastName(),
                            upIns.get().getEmail(),
                            insDetail
                    );
                    data.setFirstName(dto.getFirstName());
                    data.setLastName(dto.getLastName());
                    InstructorDetail detail = new InstructorDetail();
                    detail.setId(dto.getInstructorDetail().getId());
                    detail.setYoutubeChannel(dto.getInstructorDetail().getYoutubeChannel());
                    detail.setHobby(dto.getInstructorDetail().getHobby());
                    data.setInstructorDetail(detail);
                    insRepo.save(data);
                }
            }
        } catch (Exception ex) {
            _result = false;
        }
        return _result;
    }

    @Override
    public InstructorDto findInstructorById(Long id) {
        Optional<Instructor> ins = insRepo.findById(id);
        InstructorDto dto = new InstructorDto();
        BeanUtils.copyProperties(ins.get(), dto);
        InstructorDetailDto dtoDetail = new InstructorDetailDto();
        InstructorDetail detail = ins.get().getInstructorDetail();
        BeanUtils.copyProperties(detail, dtoDetail);
        dto.setInstructorDetail(dtoDetail);
        return dto;
    }

    @Override
    public List<InstructorDto> findInstructorByName(String firstName, String lastName) {
        List<Instructor> lstIns = new ArrayList<>();
        List<InstructorDto> lstDto = new ArrayList<>();
        lstIns = insRepo.findInstructorByName(firstName, lastName);
        if (!lstIns.isEmpty() & lstIns.size() > 0) {
            lstIns.forEach(ins -> {
                InstructorDto dto = new InstructorDto();
                BeanUtils.copyProperties(ins, dto);
                lstDto.add(dto);
            });
        }
        return lstDto;
    }

    @Override
    public List<InstructorDto> findInstructorByFirstName(String firstName) {
        List<InstructorDto> lstDto = new ArrayList<>();
        List<Instructor> lstIns = insRepo.findInstructorByFirstName(firstName);
        if (!lstIns.isEmpty() & lstIns.size() > 0) {
            lstIns.forEach(ins -> {
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
        if (!lstIns.isEmpty() & lstIns.size() > 0) {
            lstIns.forEach(ins -> {
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
        if (!lstIns.isEmpty() & lstIns.size() > 0) {
            lstIns.forEach(ins -> {
                InstructorDto dto = new InstructorDto();
                BeanUtils.copyProperties(ins, dto);
                lstDto.add(dto);
            });
        }
        return lstDto;
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        boolean _result = true;
        try {
            insRepo.deleteById(id);
        } catch (Exception ex) {
            _result = false;
        }
        return _result;
    }
}
