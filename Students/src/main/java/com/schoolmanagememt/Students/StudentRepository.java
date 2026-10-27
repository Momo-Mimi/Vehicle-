/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.schoolmanagememt.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author motho
 */ 
@Repository
public class StudentRepository {

    private final List<Student> students = new ArrayList<>();
    private Long nextId = 1L;

    // Save a student
    public Student save(Student student) {
        if (student.getId() == null) {
            student.setId(nextId++);
            students.add(student);
        } else {
            Optional<Student> existing = findById(student.getId());

            if (existing.isPresent()) {
                int index = students.indexOf(existing.get());
                students.set(index, student);
            } else {
                students.add(student);
            }
        }

        return student;
    }

    // Find all students
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    // Find one student by ID
    public Optional<Student> findById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    // Delete a student
    public void delete(Student student) {
        students.remove(student);
    }

    
}

