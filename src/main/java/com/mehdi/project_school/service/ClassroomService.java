package com.mehdi.project_school.service;

import com.mehdi.project_school.dto.response.ClassroomResponseDTO;
import com.mehdi.project_school.entity.Classroom;

public interface ClassroomService {

    Classroom create(ClassroomResponseDTO classroomResponseDTO);
}
