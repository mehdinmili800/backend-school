package com.mehdi.project_school.service.impl;

import com.mehdi.project_school.dto.response.TimeTableEntityResponseDTO;
import com.mehdi.project_school.entity.Classroom;
import com.mehdi.project_school.entity.Course;
import com.mehdi.project_school.entity.Room;
import com.mehdi.project_school.entity.TimeTableEntity;
import com.mehdi.project_school.repository.ClassroomRepository;
import com.mehdi.project_school.repository.CourseRepository;
import com.mehdi.project_school.repository.RoomRepository;
import com.mehdi.project_school.repository.TimeTableRepository;
import com.mehdi.project_school.repository.user.StudentRepository;
import com.mehdi.project_school.repository.user.TeacherRepository;
import com.mehdi.project_school.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeTableServiceImpl implements TimeTableService {

    @Autowired
    private TimeTableRepository timeTableRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Override
    public TimeTableEntity create(TimeTableEntityResponseDTO timeTableEntityResponseDTO) {
        Classroom classroom = classroomRepository.getOne(timeTableEntityResponseDTO.getClassroom_id());
        Course course = courseRepository.getOne(timeTableEntityResponseDTO.getCourse_id());
        Room room = roomRepository.getOne(timeTableEntityResponseDTO.getRoom_id());
        return timeTableRepository.save(new TimeTableEntity(
                timeTableEntityResponseDTO.getDay(),
                timeTableEntityResponseDTO.getLessonNumber(),
                room,
                course,
                classroom
        ));

    }
}
