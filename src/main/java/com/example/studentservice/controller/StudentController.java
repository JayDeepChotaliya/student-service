package com.example.studentservice.controller;

import com.example.studentservice.dto.StudentRequestDTO;
import com.example.studentservice.dto.StudentResponseDTO;
import com.example.studentservice.model.Student;
import com.example.studentservice.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController
{
    private final StudentService studentService;

    public StudentController(StudentService studentService) {this.studentService = studentService;}

    @PostMapping
    public ResponseEntity<String> createStudent(@Valid @RequestBody StudentRequestDTO studentDTO)
    {
        studentService.saveStudent(studentDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Student created successfully");
    }

    /////////////////////////

    @GetMapping
    public ResponseEntity< List<StudentResponseDTO> >getAllStudents()
    {
        List<StudentResponseDTO> studentList = studentService.getAllStudentsAsDTO();
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id)
    {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id)
    {
        studentService.deleteStudent(id);
    }
}
