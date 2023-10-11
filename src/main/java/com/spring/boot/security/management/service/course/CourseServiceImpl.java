package com.spring.boot.security.management.service.course;

import com.spring.boot.security.management.dao.CourseRepository;
import com.spring.boot.security.management.dao.InstructorRepository;
import com.spring.boot.security.management.dto.course.CourseDto;
import com.spring.boot.security.management.entity.Course;
import com.spring.boot.security.management.entity.Instructor;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepo;

    @Autowired
    InstructorRepository insRepo;

    @Override
    public List<CourseDto> findAll() {
        List<CourseDto> lstDto = new ArrayList<>();
        List<Course> lstCourse = courseRepo.findAll();
        if (!lstCourse.isEmpty() & lstCourse.size() > 0) {
            lstCourse.forEach(course -> {
                CourseDto dto = new CourseDto();
                BeanUtils.copyProperties(course, dto);
                Instructor ins = course.getInstructor();
                dto.setInstructor(ins);
                lstDto.add(dto);
            });
        }
        return lstDto;
    }

    @Override
    @Transactional
    public boolean save(CourseDto dto, Long id) {
        boolean _result = true;
        try {
            Optional<Instructor> ins = insRepo.findById(dto.getInstructor().getId());
            if (null == id) {
                Course course = new Course();
                course.setTitle(dto.getTitle());
                course.setInstructor(ins.get());
                courseRepo.save(course);
            } else {
                Optional<Course> course = courseRepo.findById(id);
                if (course.isPresent()) {
                    course.get().setInstructor(ins.get());
                    course.get().setTitle(dto.getTitle());
                }
                courseRepo.save(course.get());
            }
        } catch (Exception ex) {
            _result = false;
        }
        return _result;
    }

    @Override
    public CourseDto findById(Long id) {
        CourseDto dto = new CourseDto();
        Optional<Course> course = courseRepo.findById(id);
        BeanUtils.copyProperties(course.get(), dto);
        return dto;
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        boolean _result = true;
        try {
            courseRepo.deleteById(id);
        } catch (Exception ex) {
            _result = false;
        }
        return _result;
    }

    @Override
    public List<CourseDto> findCourseWithInstructorId(Long id) {
        List<CourseDto> lstDto = new ArrayList<>();
        List<Course> lstCourse = courseRepo.findCourseWithInstructorId(id);
        BeanUtils.copyProperties(lstCourse, lstDto);
        return lstDto;
    }

}
