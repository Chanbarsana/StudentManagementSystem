package com.example.StudentMangementSystem.Student_Mangement_System_Backend.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentMangementSystem.Student_Mangement_System_Backend.Model.Student;

import java.util.Optional;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Custom query method to find a student by email
    Optional<Student> findByEmail(String email);

    // Custom method for finding all students with pagination
    @Override
    Page<Student> findAll(Pageable pageable);
} 
