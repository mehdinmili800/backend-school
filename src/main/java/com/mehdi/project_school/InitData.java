package com.mehdi.project_school;

import com.mehdi.project_school.config.JwtService;
import com.mehdi.project_school.dto.response.UserResponseDTO;
import com.mehdi.project_school.entity.user.UserRoleName;
import com.mehdi.project_school.service.auth.impl.AuthorityServiceImpl;
import com.mehdi.project_school.service.auth.impl.UserServiceImpl;
import com.mehdi.project_school.service.impl.CourseServiceImpl;
import lombok.AllArgsConstructor;
import org.pmw.tinylog.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InitData {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private AuthorityServiceImpl authorityService;
    @Autowired
    private CourseServiceImpl courseService;
    @Autowired
    private final JwtService jwtService;



    public void Init() {
        String username = "mehdi";
        String password = "nmili";
        if(userService.findAll().isEmpty()) {
            authorityService.save(UserRoleName.ROLE_ADMIN);
            authorityService.save(UserRoleName.ROLE_STUDENT);
            authorityService.save(UserRoleName.ROLE_TEACHER);
            authorityService.save(UserRoleName.ROLE_HEADTEACHER);
            UserResponseDTO adminUser = new UserResponseDTO(username, password, "admin", "ROLE_ADMIN");
            userService.save(adminUser);

            // Generate JWT token for the default admin user
            String jwtToken = jwtService.generateToken(adminUser.toUserEntity());

            Logger.info("Username: {0}\nPassword: {1}\nJWT Token: {2}", username, password, jwtToken);
        }
        //testData();
    }



}
