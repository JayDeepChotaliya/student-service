package com.example.studentservice.service;

import com.example.studentservice.dto.StudentRequestDTO;
import com.example.studentservice.dto.StudentResponseDTO;
import com.example.studentservice.model.Student;
import com.example.studentservice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {this.studentRepository = studentRepository;}

    public Student saveStudent(StudentRequestDTO studentDTO)
    {
        Student student =new Student();

        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());

        return studentRepository.save(student);
    }

    public List<StudentResponseDTO> getAllStudentsAsDTO()
    {
        return studentRepository.findAll()
            .stream()
            .map(student -> new StudentResponseDTO(student.getId(), student.getName(), student.getEmail()))
            .collect(Collectors.toList());
    }

    public Optional<Student> getStudentById(Long id)
    {
        return studentRepository.findById(id);
    }

    public void deleteStudent(Long id)
    {
        studentRepository.deleteById(id);
    }

}
