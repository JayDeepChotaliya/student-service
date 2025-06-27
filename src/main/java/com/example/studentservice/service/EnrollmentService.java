package com.example.studentservice.service;

import com.example.studentservice.dto.EnrollmentRequestDTO;
import com.example.studentservice.dto.EnrollmentResponseDTO;
import com.example.studentservice.model.Course;
import com.example.studentservice.model.Enrollment;
import com.example.studentservice.model.Student;
import com.example.studentservice.repository.CourseRepository;
import com.example.studentservice.repository.EnrollmentRepository;
import com.example.studentservice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, StudentRepository studentRepository, CourseRepository courseRepository) {this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Enrollment saveEnrollment(EnrollmentRequestDTO enrollmentRequestDTO)
    {
        Student student = studentRepository.findById(enrollmentRequestDTO.getStudentId())
                .orElseThrow(() -> new NoSuchElementException("Student not found"));

        Course course = courseRepository.findById(enrollmentRequestDTO.getCourseId())
                .orElseThrow(()-> new NoSuchElementException("Course not found"));

        boolean alreadyEnrolled = enrollmentRepository.existsByStudentAndCourse(student,course);
        if(alreadyEnrolled)
        {
            throw new IllegalStateException("Student is already enrolled in this course");
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        return enrollmentRepository.save(enrollment);
    }
    public List<EnrollmentResponseDTO> getAllEnrollments()
    {
        return enrollmentRepository.findAll()
                .stream()
                .map(enrollment -> new EnrollmentResponseDTO(
                                                        enrollment.getId(),
                                                        enrollment.getStudent().getName(),
                                                        enrollment.getCourse().getTitle())
                )
                .collect(Collectors.toList());
    }
    public Optional<Enrollment> getEnrollmentById(Long id)
    {
        return enrollmentRepository.findById(id);
    }
    public void deleteEnrollment(Long id)
    {
        if(!enrollmentRepository.existsById(id))
        {
            throw new NoSuchElementException("Enrollment not found by Id "+id);
        }
        enrollmentRepository.deleteById(id);
    }

    public Enrollment updateEnrollment(Long id, EnrollmentRequestDTO enrollmentRequestDTO)
    {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Enrolment not found by Id "+ id ));

        Student student = studentRepository.findById(enrollmentRequestDTO.getStudentId())
                .orElseThrow(()-> new NoSuchElementException("Student not found"));

        Course course = courseRepository.findById(enrollmentRequestDTO.getCourseId())
                .orElseThrow(()->new NoSuchElementException("Course not found"));


        enrollment.setStudent(student);
        enrollment.setCourse(course);

        return enrollmentRepository.save(enrollment);

    }

}
