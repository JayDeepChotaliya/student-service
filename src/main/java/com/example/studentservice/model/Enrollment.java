package com.example.studentservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne        //Many enrollments can belong to one student
    @NotNull(message = "Student required")
    private Student student;

    @ManyToOne       //Many enrollments can belong to one Course
    @NotNull(message = "Course Required")
    private Course course;
}
