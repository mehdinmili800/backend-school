package com.mehdi.project_school.controller;

import com.mehdi.project_school.dto.response.ClassroomResponseDTO;
import com.mehdi.project_school.entity.Classroom;
import com.mehdi.project_school.service.impl.ClassroomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ClassroomController {

    @Autowired
    private ClassroomServiceImpl classroomService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/classrooms/create")
    public Classroom create(@RequestBody ClassroomResponseDTO classroomResponseDTO){
        return classroomService.create(classroomResponseDTO);
    }
}
