package com.mehdi.project_school.service;


import com.mehdi.project_school.dto.response.TimeTableEntityResponseDTO;
import com.mehdi.project_school.entity.TimeTableEntity;

public interface TimeTableService {

    TimeTableEntity create(TimeTableEntityResponseDTO timeTableEntityResponseDTO);
}
