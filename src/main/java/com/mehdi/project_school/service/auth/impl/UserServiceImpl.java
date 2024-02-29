package com.mehdi.project_school.service.auth.impl;

import com.mehdi.project_school.config.JwtService;
import com.mehdi.project_school.dto.auth.AuthenticationRequest;
import com.mehdi.project_school.dto.auth.RegisterRequest;
import com.mehdi.project_school.dto.response.AuthenticationResponse;
import com.mehdi.project_school.dto.response.UserResponseDTO;
import com.mehdi.project_school.entity.Course;
import com.mehdi.project_school.entity.group.Student;
import com.mehdi.project_school.entity.group.Teacher;
import com.mehdi.project_school.entity.user.Authority;
import com.mehdi.project_school.entity.user.User;
import com.mehdi.project_school.entity.user.UserRoleName;
import com.mehdi.project_school.exception.CustomException;
import com.mehdi.project_school.repository.ExamRepository;
import com.mehdi.project_school.repository.user.AuthorityRepository;
import com.mehdi.project_school.repository.user.StudentRepository;
import com.mehdi.project_school.repository.user.TeacherRepository;
import com.mehdi.project_school.repository.user.UserRepository;
import com.mehdi.project_school.service.auth.AuthorityService;
import com.mehdi.project_school.service.auth.UserService;
import com.mehdi.project_school.token.TokenEntity;
import com.mehdi.project_school.token.TokenRepository;
import com.mehdi.project_school.token.TokenType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authService;

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;




    @Override
    public User save(UserResponseDTO userResponseDTO) {
        if(!userRepository.existsByUsername(userResponseDTO.getUsername())) {
            User newUser = new User();
            newUser.setUsername(userResponseDTO.getUsername());
            newUser.setPassword(passwordEncoder.encode(userResponseDTO.getPassword()));
            newUser.setFullName(userResponseDTO.getFullName());
            List<Authority> authorities = authService.findByName(userResponseDTO.getRole());
            newUser.setAuthorities(authorities);
            userRepository.save(newUser);
            return newUser;
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public String delete(Long user_id) {
        User user = userRepository.getOne(user_id);

        if (user != null) {
            // Check if the user is a teacher
            if (!user.getTeachers().isEmpty()) {
                // User is a teacher, delete teacher-related data
                Teacher teacher = user.getTeachers().get(0); // Assuming a user can have only one associated teacher

                // Delete exams related to teacher's courses
                for (Course course : teacher.getCourses()) {
                    examRepository.deleteAllByCourse(course);
                }

                // Delete teacher-related data
                teacherRepository.delete(teacher);
                // Additional logic for deleting teacher-related data if needed
            }

            // Check if the user is a student
            if (!user.getStudents().isEmpty()) {
                // User is a student, delete student-related data
                Student student = user.getStudents().get(0); // Assuming a user can have only one associated student
                studentRepository.delete(student);
                // Additional logic for deleting student-related data if needed
            }

            userRepository.delete(user);
            return user_id.toString();
        } else {
            return "User not found";
        }
    }




    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();

        // استرجاع الرول (Role) من اليوزر (User)
        String userRole = user.getAuthorities().stream()
                .findFirst()
                .map(authority -> authority.getAuthority())
                .orElse("ROLE_USER");

        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
//        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .role(userRole)
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = TokenEntity.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }




}
