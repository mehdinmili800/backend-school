package com.mehdi.project_school.service.impl;

import com.mehdi.project_school.dto.response.RoomResponseDTO;
import com.mehdi.project_school.entity.Room;
import com.mehdi.project_school.repository.RoomRepository;
import com.mehdi.project_school.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;


    @Override
    public Room create(RoomResponseDTO roomResponseDTO) {
        return roomRepository.save(new Room(
                roomResponseDTO.getClassroomNumber()
        ));
    }
}
