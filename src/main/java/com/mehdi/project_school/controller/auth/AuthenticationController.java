package com.mehdi.project_school.controller.auth;

import com.mehdi.project_school.dto.auth.AuthenticationRequest;
import com.mehdi.project_school.dto.response.AuthenticationResponse;
import com.mehdi.project_school.service.auth.UserService;
import com.mehdi.project_school.service.auth.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth" )
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserServiceImpl service;



    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

}
