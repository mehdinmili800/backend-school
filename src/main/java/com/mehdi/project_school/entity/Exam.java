package com.mehdi.project_school.entity;


import com.mehdi.project_school.entity.group.Student;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Exam model class store exam info and result.
 */
@Entity
@Table(name = "exams")
public class Exam {

    /**
     * Id field [GENERATED AUTOMATICALLY].
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Exam result.
     */
    @Column(name = "mark", nullable = false)
    private int mark;

    /**
     * Time when exam written.
     */
    @Column(name = "written_at", nullable = false)
    private String writtenAt;


    /**
     * Empty constructor.
     */
    public Exam() {}

    /**
     * Constructor to make a new instance.
     *
     * @param mark Exam result.
     * @param writtenAt Time when exam written.
     * @param course Course where student wrote the exam.
     * @param student Student who wrote the exam.
     */
    public Exam(int mark, String writtenAt, Course course, Student student) {
        this.mark = mark;
        this.writtenAt = writtenAt;
        this.course = course;
        this.student = student;
    }

    /**
     * Course where student wrote the exam.
     */
    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    /**
     * Student who wrote the exam.
     */
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getWrittenAt() {
        return writtenAt;
    }

    public void setWrittenAt(String writtenAt) {
        this.writtenAt = writtenAt;
    }



    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
