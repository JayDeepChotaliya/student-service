package com.example.studentservice.service;

import com.example.studentservice.dto.CourseRequestDTO;
import com.example.studentservice.dto.CourseResponseDTO;
import com.example.studentservice.model.Course;
import com.example.studentservice.repository.CourseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService
{
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {this.courseRepository = courseRepository;}

    public Course saveCourse(CourseRequestDTO courseRequestDTO)
    {
        Course course = new Course();
        course.setTitle(courseRequestDTO.getTitle());
        course.setDescription(courseRequestDTO.getDescription());
        return courseRepository.save(course);
    }
    public List<CourseResponseDTO > getAllCourses()
    {
        return courseRepository.findAll()
                .stream()
                .map(course -> new CourseResponseDTO(
                        course.getId(),
                        course.getTitle(),
                        course.getDescription()
                ))
                .collect(Collectors.toList());
    }
    public Optional<Course> getCourseById(Long id)
    {
        return courseRepository.findById(id);
    }
    public void deleteCourse(Long id)
    {
        courseRepository.deleteById(id);
    }
}
