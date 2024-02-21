package com.mehdi.project_school.service.impl;

import com.mehdi.project_school.dto.response.ClassroomResponseDTO;
import com.mehdi.project_school.entity.Classroom;
import com.mehdi.project_school.entity.group.Teacher;
import com.mehdi.project_school.repository.ClassroomRepository;
import com.mehdi.project_school.repository.user.StudentRepository;
import com.mehdi.project_school.repository.user.TeacherRepository;
import com.mehdi.project_school.service.ClassroomService;
import com.mehdi.project_school.service.auth.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    private AuthorityService authorityService;

    @Override
    public Classroom create(ClassroomResponseDTO classroomResponseDTO) {
        Teacher teacher = teacherRepository.getOne(classroomResponseDTO.getHeadTeacher_id());
        Classroom classroom = new Classroom(
                classroomResponseDTO.getStart_year(),
                classroomResponseDTO.getEnd_year(),
                classroomResponseDTO.getYear(),
                classroomResponseDTO.getLetter(),
                teacher
        );
        classroomRepository.setHeadteacherFromTeacher(teacherRepository.GetUserIdByTeacherId(teacher.getId()));
        return classroomRepository.save(classroom);
    }
}
