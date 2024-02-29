package com.mehdi.project_school.service;

import com.mehdi.project_school.dto.response.ExamResponseDTO;
import com.mehdi.project_school.entity.Course;
import com.mehdi.project_school.entity.Exam;

import java.util.List;

public interface ExamService {

    Exam create(ExamResponseDTO examResponseDTO);

    List<Exam> findAll();
}
