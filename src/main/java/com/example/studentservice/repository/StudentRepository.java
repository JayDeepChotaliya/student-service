package com.example.studentservice.repository;

import com.example.studentservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Long>
{

}
