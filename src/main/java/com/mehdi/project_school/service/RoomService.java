package com.mehdi.project_school.service;

import com.mehdi.project_school.dto.response.RoomResponseDTO;
import com.mehdi.project_school.entity.Room;

public interface RoomService {

    Room create(RoomResponseDTO roomResponseDTO);
}
