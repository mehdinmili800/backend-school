package com.mehdi.project_school.controller;

import com.mehdi.project_school.dto.response.StudentResponseDTO;
import com.mehdi.project_school.entity.group.Student;
import com.mehdi.project_school.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/api")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/students/create")
    public ResponseEntity<?> create(@RequestBody StudentResponseDTO studentResponseDTO,
                                    UriComponentsBuilder uriComponentsBuilder){
        Student student = studentService.create(studentResponseDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/api/user/{userId}").buildAndExpand(student.getId()).toUri());
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }
}
