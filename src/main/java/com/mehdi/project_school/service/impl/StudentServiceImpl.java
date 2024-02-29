package com.mehdi.project_school.service.impl;

import com.mehdi.project_school.dto.response.StudentResponseDTO;
import com.mehdi.project_school.entity.Attendance;
import com.mehdi.project_school.entity.Classroom;
import com.mehdi.project_school.entity.Exam;
import com.mehdi.project_school.entity.Report;
import com.mehdi.project_school.entity.group.Gender;
import com.mehdi.project_school.entity.group.Student;
import com.mehdi.project_school.entity.user.Authority;
import com.mehdi.project_school.entity.user.User;
import com.mehdi.project_school.repository.ClassroomRepository;
import com.mehdi.project_school.repository.ExamRepository;
import com.mehdi.project_school.repository.ReportRepository;
import com.mehdi.project_school.repository.user.StudentRepository;
import com.mehdi.project_school.repository.user.UserRepository;
import com.mehdi.project_school.service.StudentService;
import com.mehdi.project_school.service.auth.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private ExamRepository examRepository;

    @Override
    public Student create(StudentResponseDTO studentResponseDTO) {
        User user = userRepository.findByUsername(studentResponseDTO.getUsername())
                .orElseThrow(() -> new NoSuchElementException("User not found with username: " + studentResponseDTO.getUsername()));
//        Classroom classroom = classroomRepository.getOne(studentResponseDTO.getClassroom_id());
        Student student = new Student();

        student.setAddress(studentResponseDTO.getAddress());
//        student.setClassroom(classroom);
        student.setDateOfBirth(studentResponseDTO.getDateOfBirth());
        student.setGender(Gender.valueOf(studentResponseDTO.getGender()));
        student.setEducationId(studentResponseDTO.getEducationId());
        student.setFullName(studentResponseDTO.getFullName());
//        student.setStart_year(studentResponseDTO.getStart_year());
        student.setParent1Name(studentResponseDTO.getParent1Name());
        student.setParent2Name(studentResponseDTO.getParent2Name());
        student.setParent1Phone(studentResponseDTO.getParent1Phone());
        student.setParent2Phone(studentResponseDTO.getParent2Phone());
        List<Authority> authorities = authorityService.findByName("ROLE_STUDENT");
        user.setAuthorities(authorities);
        student.setStudent(user);
        studentRepository.save(student);
        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

//    @Override
//    public void delete(Long id) {
//        deleteStudentData(id);
//        studentRepository.deleteById(id);
//    }
//
//    private void deleteStudentData(Long student_id) {
//        deleteAllExamByStudent(student_id);
//        deleteAllReportByStudent(student_id);
//    }
//
//    /**
//     * Deletes all exam which student wrote.
//     *
//     * @param student_id Id of the student.
//     */
//    private void deleteAllExamByStudent(Long student_id) {
//        List<Exam> examsToDelete = examRepository.findByStudentId(student_id);
//        examRepository.deleteAll(examsToDelete);
//    }
//
//
//    /**
//     * Deletes all reports which connected to student except the archived reports.
//     *
//     * @param student_id Id of the student.
//     */
//    private void deleteAllReportByStudent(Long student_id) {
//        for(Report report: reportRepository.findAll()) {
//            if(report.getStudent().getId().equals(student_id)) {
//                reportRepository.delete(report);
//            }
//        }
//    }

}
