package com.deven.demo.Student_Management_System.Controller;

import com.deven.demo.Student_Management_System.Entity.Student;
import com.deven.demo.Student_Management_System.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Show All Students (already implemented)
    @GetMapping("/")
    public String showAllStudents(Model model) {
        model.addAttribute("listStudents", studentService.getAllStudent());
        return "index";
    }

    // Show New Student Form (already implemented)
    @GetMapping("/addStudent")
    public String showNewStudent(Model model) {
        model.addAttribute("student", new Student());
        return "add_student";
    }

    // Save New Student (already implemented)
    @PostMapping("/saveStudent")
    public String saveStudent(Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }

    // Edit Existing Student - show the form pre-filled with data
    @GetMapping("/updateStudent/{id}")
    public String showUpdateStudentForm(@PathVariable("id") int id, Model model) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            // Handle case where student with ID doesn't exist
            return "redirect:/";  // Or show an error message
        }
        model.addAttribute("student", student);
        return "add_student";  // Reusing the "add_student" form for editing
    }

    // Update Student (after form submission)
    @PostMapping("/updateStudent")
    public String updateStudent(Student student) {
        studentService.updateStudent(student);
        return "redirect:/";  // Redirect after update
    }

    // Delete a Student by ID
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return "redirect:/";  // Redirect after deletion
    }
}
