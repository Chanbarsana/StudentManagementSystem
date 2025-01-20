package com.example.StudentMangementSystem.Student_Mangement_System_Backend.Service;

import java.util.List;

import com.example.StudentMangementSystem.Student_Mangement_System_Backend.Model.Student;

public interface IStudentService {

    Student addStudent(Student student);
    List<Student> getStudents();
    Student updateStudent(Student student, Long id);
    Student getStudentById(Long id);
    void deleteStudent(Long id);
}