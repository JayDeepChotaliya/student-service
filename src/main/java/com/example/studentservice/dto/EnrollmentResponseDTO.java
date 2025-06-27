package com.example.studentservice.dto;

public class EnrollmentResponseDTO
{
        private Long id;
        private String studentName;
        private String courseTitle;

    public EnrollmentResponseDTO() {
    }

    public EnrollmentResponseDTO(Long id, String studentName, String courseTitle) {
        this.id = id;
        this.studentName = studentName;
        this.courseTitle = courseTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
}
