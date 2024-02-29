package com.mehdi.project_school.service;

import com.mehdi.project_school.dto.response.TeacherResponseDTO;
import com.mehdi.project_school.entity.group.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAll();
    Teacher create(TeacherResponseDTO teacherResponseDTO);

//    void delete(Long id);

}
