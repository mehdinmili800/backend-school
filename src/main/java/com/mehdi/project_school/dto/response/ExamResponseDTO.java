package com.mehdi.project_school.dto.response;

import java.time.LocalDate;

public class ExamResponseDTO {

    private int mark;

    private String written_at;



    private Long course_id;

    private Long student_id;

    public ExamResponseDTO() {
    }

    public ExamResponseDTO(int mark, String written_at,Long course_id, Long student_id) {
        this.mark = mark;
        this.written_at = written_at;
        this.course_id = course_id;
        this.student_id = student_id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getWritten_at() {
        return written_at;
    }

    public void setWritten_at(String written_at) {
        this.written_at = written_at;
    }



    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }
}
