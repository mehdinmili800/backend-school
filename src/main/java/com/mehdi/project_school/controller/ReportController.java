package com.mehdi.project_school.controller;

import com.mehdi.project_school.dto.response.ReportResponseDTO;
import com.mehdi.project_school.entity.Report;
import com.mehdi.project_school.service.impl.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ReportController {

    @Autowired
    private ReportServiceImpl reportService;

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @PostMapping(value = "/reports/create")
    public Report create(@RequestBody ReportResponseDTO reportResponseDTO){
        return reportService.create(reportResponseDTO);
    }
}
