package com.mehdi.project_school.service.auth;


import com.mehdi.project_school.dto.response.UserResponseDTO;
import com.mehdi.project_school.entity.user.User;

import java.util.List;

public interface UserService {


    User save(UserResponseDTO userResponseDTO);

    List<User> findAll();

    String delete(Long user_id);




}
