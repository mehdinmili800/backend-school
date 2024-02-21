package com.mehdi.project_school.service;

import com.mehdi.project_school.dto.response.ExamResponseDTO;
import com.mehdi.project_school.entity.Exam;

public interface ExamService {

    Exam create(ExamResponseDTO examResponseDTO);
}
