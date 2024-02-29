package com.mehdi.project_school.service;

import com.mehdi.project_school.dto.response.StudentResponseDTO;
import com.mehdi.project_school.entity.group.Student;

import java.util.List;

public interface StudentService {

    Student create(StudentResponseDTO studentResponseDTO);

    List<Student> findAll();


    Student findById(Long id);


}
