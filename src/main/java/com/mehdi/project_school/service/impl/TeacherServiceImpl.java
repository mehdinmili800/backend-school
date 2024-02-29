package com.mehdi.project_school.service.impl;

import com.mehdi.project_school.dto.response.TeacherResponseDTO;
import com.mehdi.project_school.entity.Course;
import com.mehdi.project_school.entity.Exam;
import com.mehdi.project_school.entity.Report;
import com.mehdi.project_school.entity.group.Teacher;
import com.mehdi.project_school.entity.user.Authority;
import com.mehdi.project_school.entity.user.User;
import com.mehdi.project_school.repository.CourseRepository;
import com.mehdi.project_school.repository.ExamRepository;
import com.mehdi.project_school.repository.user.TeacherRepository;
import com.mehdi.project_school.repository.user.UserRepository;
import com.mehdi.project_school.service.auth.AuthorityService;
import com.mehdi.project_school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ExamRepository examRepository;




    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher create(TeacherResponseDTO teacherResponseDTO) {
        // Check if the user exists
        User user = userRepository.findByUsername(teacherResponseDTO.getUsername())
                .orElseThrow(() -> new NoSuchElementException("User not found with username: " + teacherResponseDTO.getUsername()));

        Teacher teacher = new Teacher();
        teacher.setEmail(teacherResponseDTO.getEmail());
        teacher.setPhone(teacherResponseDTO.getPhone());

        List<Authority> authorities = authorityService.findByName("ROLE_TEACHER");
        user.setAuthorities(authorities);

        teacher.setTeacher(user);
        teacherRepository.save(teacher);

        return teacher;
    }

//    @Override
//    public void delete(Long id) {
//        deleteAllCourseByStudent(id);
//        deleteAllExamByStudent(id);
//
//
//        teacherRepository.deleteById(id);
//    }
//
//    private void deleteAllExamByStudent(Long student_id) {
//        List<Exam> examsToDelete = examRepository.findByStudentId(student_id);
//        examRepository.deleteAll(examsToDelete);
//    }
//
//    private void deleteAllCourseByStudent(Long teacher_id) {
//        List<Course> examsToDelete = courseRepository.findByTeacherId(teacher_id);
//        courseRepository.deleteAll(examsToDelete);
//    }
}
