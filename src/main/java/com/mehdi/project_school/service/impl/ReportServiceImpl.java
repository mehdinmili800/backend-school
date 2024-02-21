package com.mehdi.project_school.service.impl;

import com.mehdi.project_school.dto.response.ReportResponseDTO;
import com.mehdi.project_school.entity.Course;
import com.mehdi.project_school.entity.Report;
import com.mehdi.project_school.entity.group.Student;
import com.mehdi.project_school.repository.CourseRepository;
import com.mehdi.project_school.repository.ReportRepository;
import com.mehdi.project_school.repository.user.StudentRepository;
import com.mehdi.project_school.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public Report create(ReportResponseDTO reportResponseDTO) {
        Student student = studentRepository.getOne(reportResponseDTO.getStudent_id());
        Course course = courseRepository.getOne(reportResponseDTO.getCourse_id());
        return reportRepository.save(new Report(
                student,
                reportResponseDTO.getYear(),
                reportResponseDTO.getSemester(),
                course,
                reportResponseDTO.getMark()
        ));
    }
}
