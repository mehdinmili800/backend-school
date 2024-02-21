package com.mehdi.project_school.service.impl;

import com.mehdi.project_school.dto.response.CourseResponseDTO;
import com.mehdi.project_school.entity.Course;
import com.mehdi.project_school.entity.group.Teacher;
import com.mehdi.project_school.repository.CourseRepository;
import com.mehdi.project_school.repository.user.StudentRepository;
import com.mehdi.project_school.repository.user.TeacherRepository;
import com.mehdi.project_school.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public Course create(CourseResponseDTO courseResponseDTO) {
        Teacher teacher = teacherRepository.getOne(courseResponseDTO.getTeacher_id());
        return courseRepository.save(new Course(
                courseResponseDTO.getTitle(),
                courseResponseDTO.getYear(),
                teacher
        ));
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
