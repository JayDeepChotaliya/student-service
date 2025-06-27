package com.example.studentservice.dto;

import jakarta.validation.constraints.NotNull;

public class EnrollmentRequestDTO {

    @NotNull(message = "Student Id is required")
    private Long studentId;
    @NotNull(message = "Course Id is required")
    private Long courseId;

    public EnrollmentRequestDTO() {
    }

    public EnrollmentRequestDTO(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
