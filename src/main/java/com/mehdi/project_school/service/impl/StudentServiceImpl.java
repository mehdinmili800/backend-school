package com.mehdi.project_school.service.impl;

import com.mehdi.project_school.dto.response.StudentResponseDTO;
import com.mehdi.project_school.entity.Classroom;
import com.mehdi.project_school.entity.group.Gender;
import com.mehdi.project_school.entity.group.Student;
import com.mehdi.project_school.entity.user.User;
import com.mehdi.project_school.repository.ClassroomRepository;
import com.mehdi.project_school.repository.user.StudentRepository;
import com.mehdi.project_school.repository.user.UserRepository;
import com.mehdi.project_school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClassroomRepository classroomRepository;
    @Override
    public Student create(StudentResponseDTO studentResponseDTO) {
        User user = userRepository.findByUsername(studentResponseDTO.getUsername()).orElseThrow();
        Classroom classroom = classroomRepository.getOne(studentResponseDTO.getClassroom_id());
        Student student = new Student();

        student.setAddress(studentResponseDTO.getAddress());
        student.setClassroom(classroom);
        student.setDateOfBirth(studentResponseDTO.getDateOfBirth());
        student.setGender(Gender.valueOf(studentResponseDTO.getGender()));
        student.setEducationId(studentResponseDTO.getEducationId());
        student.setHealthCareId(studentResponseDTO.getHealthCareId());
        student.setStart_year(studentResponseDTO.getStart_year());
        student.setParent1Name(studentResponseDTO.getParent1Name());
        student.setParent2Name(studentResponseDTO.getParent2Name());
        student.setParent1Phone(studentResponseDTO.getParent1Phone());
        student.setParent2Phone(studentResponseDTO.getParent2Phone());
        student.setStudent(user);
        studentRepository.save(student);
        return student;
    }
}
