package com.mehdi.project_school.controller;

import com.mehdi.project_school.dto.response.ExamResponseDTO;
import com.mehdi.project_school.entity.Course;
import com.mehdi.project_school.entity.Exam;
import com.mehdi.project_school.service.impl.ExamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ExamController {

    @Autowired
    private ExamServiceImpl examService;


    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER') or hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/exams/create")
    public Exam create(@RequestBody ExamResponseDTO examResponseDTO){
        return examService.create(examResponseDTO);
    }

    @GetMapping(value = "/exam/all")
    public List<Exam> findAll(){
        return examService.findAll();
    }
}
