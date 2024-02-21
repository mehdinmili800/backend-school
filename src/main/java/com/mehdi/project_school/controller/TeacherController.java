package com.mehdi.project_school.controller;

import com.mehdi.project_school.dto.response.TeacherResponseDTO;
import com.mehdi.project_school.entity.group.Teacher;
import com.mehdi.project_school.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/teachers/create")
    public Teacher create(@RequestBody TeacherResponseDTO teacherResponseDTO){
        return teacherService.create(teacherResponseDTO);
    }
}
