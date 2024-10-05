package com.deven.demo.Student_Management_System.Service;

import com.deven.demo.Student_Management_System.Entity.Student;
import com.deven.demo.Student_Management_System.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);  // Saves the student to the database
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);  // Fetch the student by ID
    }

    @Override
    public Student updateStudent(Student student) {
        // The save method is used here to update the student.
        return studentRepository.save(student);  // Save the updated student
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);  // Deletes the student by ID
    }
}
