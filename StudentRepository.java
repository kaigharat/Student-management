package com.deven.demo.Student_Management_System.Repository;

import com.deven.demo.Student_Management_System.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // JpaRepository provides default methods for CRUD operations like save, findById, findAll, deleteById
}
