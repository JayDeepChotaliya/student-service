package com.example.studentservice.repository;

import com.example.studentservice.model.Course;
import com.example.studentservice.model.Enrollment;
import com.example.studentservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long>
{
    boolean existsByStudentAndCourse(Student student , Course course);
}
