package com.example.studentservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
        @Entity → Marks this as a database table
        @Id → Primary key
        @GeneratedValue → Auto-generates ID values
        @Data → Lombok shortcut: adds getters, setters, toString(), etc.
        @NoArgsConstructor & @AllArgsConstructor → Required for Spring + Lombok
 */

@Entity  /// which tells Spring Boot and JPA: “This class maps to a table in the database.”
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Student name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;


}
