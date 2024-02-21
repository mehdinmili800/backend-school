package com.mehdi.project_school.service;

import com.mehdi.project_school.dto.response.CourseResponseDTO;
import com.mehdi.project_school.entity.Course;

import java.util.List;

public interface CourseService {

    Course create(CourseResponseDTO courseResponseDTO);

    List<Course> findAll();
}
