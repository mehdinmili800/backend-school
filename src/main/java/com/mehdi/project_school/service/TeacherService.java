package com.mehdi.project_school.service;

import com.mehdi.project_school.dto.response.TeacherResponseDTO;
import com.mehdi.project_school.entity.group.Teacher;

public interface TeacherService {

    Teacher create(TeacherResponseDTO teacherResponseDTO);
}
