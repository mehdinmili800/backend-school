package com.mehdi.project_school.controller;

import com.mehdi.project_school.dto.response.ExamResponseDTO;
import com.mehdi.project_school.entity.Exam;
import com.mehdi.project_school.service.impl.ExamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ExamController {

    @Autowired
    private ExamServiceImpl examService;


    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @PostMapping(value = "/exams/create")
    public Exam create(@RequestBody ExamResponseDTO examResponseDTO){
        return examService.create(examResponseDTO);
    }
}
