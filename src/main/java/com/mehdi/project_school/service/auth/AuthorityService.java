package com.mehdi.project_school.service.auth;


import com.mehdi.project_school.entity.user.Authority;
import com.mehdi.project_school.entity.user.UserRoleName;

import java.util.List;

public interface AuthorityService {

    void save(UserRoleName userRoleName);


    List<Authority> findByName(String name);

}
