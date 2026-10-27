/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.schoolmanagememt.Students;

import java.util.List;
import org.springframework.stereotype.Service;
/**
 *
 * @author motho
 */
@Service
public class studentService 
{

   private final StudentRepository repository;

    public studentService(StudentRepository repository) 
    {
        this.repository = repository;
    }

    // Create a student
    public Student create(Student student) 
    {
        student.setId(null);
        return repository.save(student);
    }

    // Read all students
    public List<Student> getAll() 
    {
        return repository.findAll();
    }

    // Read one student
    public Student getById(Long id) 
    {
        return repository.findById(id).orElseThrow(() ->new StudentNotFoundException("Student with ID " + id + " was not found"));
    }

    // Update a student
    public Student update(Long id, Student updatedStudent) 
    {
        Student existing = getById(id);

        existing.setFullName(updatedStudent.getFullName());
        existing.setCourse(updatedStudent.getCourse());

        return repository.save(existing);
    }

    // Delete a student
    public void delete(Long id) 
    {
        Student student = getById(id);
        repository.delete(student);
    }

}

