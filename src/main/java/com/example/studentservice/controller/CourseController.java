package com.example.studentservice.controller;

import com.example.studentservice.dto.CourseRequestDTO;
import com.example.studentservice.dto.CourseResponseDTO;
import com.example.studentservice.model.Course;
import com.example.studentservice.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {this.courseService = courseService;}

    @PostMapping
    public ResponseEntity<String> createCourse(@Valid @RequestBody CourseRequestDTO courseRequestDTO)
    {
        courseService.saveCourse(courseRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                                .body("Course created successfully");
    }

    @GetMapping()
    public ResponseEntity<List<CourseResponseDTO>>  getAllCourses()
    {
        return ResponseEntity.ok(courseService.getAllCourses());
    }
    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id)
    {
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

}
