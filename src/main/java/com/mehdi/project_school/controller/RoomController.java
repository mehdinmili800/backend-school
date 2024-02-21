package com.mehdi.project_school.controller;

import com.mehdi.project_school.dto.response.RoomResponseDTO;
import com.mehdi.project_school.entity.Room;
import com.mehdi.project_school.service.impl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class RoomController {

    @Autowired
    private RoomServiceImpl roomService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/room/create")
    public Room create(@RequestBody RoomResponseDTO roomResponseDTO){
        return roomService.create(roomResponseDTO);
    }



}
