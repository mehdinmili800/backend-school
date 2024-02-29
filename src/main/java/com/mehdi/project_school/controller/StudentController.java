package com.mehdi.project_school.controller;

import com.mehdi.project_school.dto.response.StudentResponseDTO;
import com.mehdi.project_school.entity.group.Student;
import com.mehdi.project_school.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_STUDENT')")
    @PostMapping(value = "/students/create")
    public Student create(@RequestBody StudentResponseDTO studentResponseDTO){
        return studentService.create(studentResponseDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @GetMapping(value = "/students/all")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping(value = "/students/{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }





}
