package com.mehdi.project_school.controller;

import com.mehdi.project_school.dto.response.TimeTableEntityResponseDTO;
import com.mehdi.project_school.entity.TimeTableEntity;
import com.mehdi.project_school.service.impl.TimeTableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class TimeTableController {

    @Autowired
    private TimeTableServiceImpl timeTableService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/timetables/create")
    public TimeTableEntity create(@RequestBody TimeTableEntityResponseDTO timeTableEntityResponseDTO){
        return timeTableService.create(timeTableEntityResponseDTO);
    }
}
