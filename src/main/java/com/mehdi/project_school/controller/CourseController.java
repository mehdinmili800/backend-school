package com.mehdi.project_school.controller;

import com.mehdi.project_school.dto.response.CourseResponseDTO;
import com.mehdi.project_school.entity.Course;
import com.mehdi.project_school.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api")
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/courses/create")
    public Course create(@RequestBody CourseResponseDTO courseResponseDTO){
        return courseService.create(courseResponseDTO);
    }

    @GetMapping(value = "/course/all")
    public List<Course> findAll(){
        return courseService.findAll();
    }
}
