package com.deven.demo.Student_Management_System.Service;

import com.deven.demo.Student_Management_System.Entity.Student;

import java.util.List;

public interface StudentService {

    // Get all students
    List<Student> getAllStudent();

    // Save a student (create or update)
    Student saveStudent(Student student);

    // Get a student by ID
    Student getStudentById(int id);

    // Update a student
    Student updateStudent(Student student);

    // Delete a student by ID
    void deleteStudent(int id);
}
