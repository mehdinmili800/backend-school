package com.mehdi.project_school.repository;


import com.mehdi.project_school.entity.Course;
import com.mehdi.project_school.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {



    void deleteAllByCourse(Course course);


}
