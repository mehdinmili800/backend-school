package com.mehdi.project_school.service;

import com.mehdi.project_school.dto.response.ReportResponseDTO;
import com.mehdi.project_school.entity.Report;

public interface ReportService {


    Report create(ReportResponseDTO reportResponseDTO);
}
