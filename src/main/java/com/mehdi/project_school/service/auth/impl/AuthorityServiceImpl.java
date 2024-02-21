package com.mehdi.project_school.service.auth.impl;

import com.mehdi.project_school.entity.user.Authority;
import com.mehdi.project_school.entity.user.UserRoleName;
import com.mehdi.project_school.repository.user.AuthorityRepository;
import com.mehdi.project_school.service.auth.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;
    @Override
    public void save(UserRoleName userRoleName) {
        authorityRepository.saveAuth(userRoleName.toString());
    }

    @Override
    public List<Authority> findByName(String name) {
        Authority authority = getAuthority(name);
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authority);
        return authorities;
    }

    private Authority getAuthority(String name) {
        for(Authority authority : authorityRepository.findAll()) {
            if(authority.getAuthority().equals(name)) {
                return authority;
            }
        }
        return null;
    }
}
