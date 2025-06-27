package com.example.studentservice.controller;

import com.example.studentservice.dto.EnrollmentRequestDTO;
import com.example.studentservice.dto.EnrollmentResponseDTO;
import com.example.studentservice.model.Enrollment;
import com.example.studentservice.service.EnrollmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {this.enrollmentService = enrollmentService;}

    @PostMapping
    public ResponseEntity<String> createEnrollment(@Valid @RequestBody EnrollmentRequestDTO enrollmentRequestDTO)
    {
        enrollmentService.saveEnrollment(enrollmentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                                .body("Enrollment created successfully");
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentResponseDTO>> getAllEnrollments()
    {
        return ResponseEntity.ok(enrollmentService.getAllEnrollments());
    }

    @GetMapping("/{id}")
    public Optional<Enrollment> getEnrollmentById(@PathVariable Long id)
    {
        return enrollmentService.getEnrollmentById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable Long id)
    {

        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.ok("Enrollment deleted successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEnrollment(@PathVariable Long id,
                                                   @Valid
                                                   @RequestBody EnrollmentRequestDTO enrollmentRequestDTO)
    {
        enrollmentService.updateEnrollment(id,enrollmentRequestDTO);
        return ResponseEntity.ok("Enrollment updated successfully");
    }

}
