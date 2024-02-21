package com.mehdi.project_school.service.impl;

import com.mehdi.project_school.dto.response.ExamResponseDTO;
import com.mehdi.project_school.entity.Course;
import com.mehdi.project_school.entity.Exam;
import com.mehdi.project_school.entity.group.Student;
import com.mehdi.project_school.repository.CourseRepository;
import com.mehdi.project_school.repository.ExamRepository;
import com.mehdi.project_school.repository.user.StudentRepository;
import com.mehdi.project_school.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;


    @Override
    public Exam create(ExamResponseDTO examResponseDTO){
        Student student = studentRepository.getOne(examResponseDTO.getStudent_id());
        Course course = courseRepository.getOne(examResponseDTO.getCourse_id());


            return examRepository.save(new Exam(
                    examResponseDTO.getMark(),
                    examResponseDTO.getWritten_at(),
                    course,
                    student
            ));


    }
}
