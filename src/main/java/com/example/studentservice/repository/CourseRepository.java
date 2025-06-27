package com.example.studentservice.repository;

import com.example.studentservice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long>
{
}
