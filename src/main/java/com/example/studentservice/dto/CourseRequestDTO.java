package com.example.studentservice.dto;

import jakarta.validation.constraints.NotBlank;

public class CourseRequestDTO
{
    @NotBlank(message = "Course title is required")
    private String title;
    @NotBlank(message = "Description is required")
    private String description;

    public CourseRequestDTO() {
    }

    public CourseRequestDTO(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
