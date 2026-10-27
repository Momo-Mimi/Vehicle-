/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.schoolmanagememt.Students;
import jakarta.validation.Valid;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mothomi
 */
@RestController
@RequestMapping("/api")
public class StudentController 
{

    private final studentService service;
    public StudentController(studentService service) 
    {
        this.service = service;
    }

     // Activity 1: Return a JSON response
    //http://localhost:8080/api/hello
    @GetMapping("/hello")
    public Map<String, String> hello() 
    {
        return Map.of("message", "Welcome to the Student Management API","status", "Success");
    }
    

    // Activity 2: Create a student
    //http://localhost:8080/api/students
    @PostMapping("/students")
    public ResponseEntity<Student> create(@Valid @RequestBody Student student) 
    {
        Student saved = service.create(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Activity 2: Read all students
    //http://localhost:8080/api/students
    @GetMapping("/students")
    public ResponseEntity<?> getAll() 
    {
        return ResponseEntity.ok(service.getAll());
    }

    // Activity 2: Read one student
    //http://localhost:8080/api/students/{id}
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) 
    {
        checkId(id);
        return ResponseEntity.ok(service.getById(id));
    }

    // Activity 2: Update a student
    //http://localhost:8080/api/students/{id}
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id,@Valid @RequestBody Student student) 
    {
        checkId(id);
        return ResponseEntity.ok(service.update(id, student));
    }

    // Activity 2: Delete a student
    //http://localhost:8080/api/students/{id}
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) 
    {
        checkId(id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Check that the student ID is valid
    private void checkId(Long id) 
    {
        if (id == null || id <= 0) 
        {
            throw new IllegalArgumentException("Student ID must be a positive number");
        }
    }
}
    