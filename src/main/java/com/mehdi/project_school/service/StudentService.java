package com.mehdi.project_school.service;

import com.mehdi.project_school.dto.response.StudentResponseDTO;
import com.mehdi.project_school.entity.group.Student;

public interface StudentService {

    Student create(StudentResponseDTO studentResponseDTO);
}
