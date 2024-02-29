package com.mehdi.project_school.controller;

import com.mehdi.project_school.dto.response.TeacherResponseDTO;
import com.mehdi.project_school.entity.group.Teacher;
import com.mehdi.project_school.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @PostMapping(value = "/teachers/create")
    public Teacher create(@RequestBody TeacherResponseDTO teacherResponseDTO){
        return teacherService.create(teacherResponseDTO);
    }

    @GetMapping(value = "/teachers/all")
    public List<Teacher> findAll(){
        return teacherService.findAll();
    }



//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @DeleteMapping(value = "/teachers/{id}")
//    public String delete(@PathVariable Long id) {
//        teacherService.delete(id);
//        return id.toString();
//    }
}
