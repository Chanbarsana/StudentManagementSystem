package com.example.StudentMangementSystem.Student_Mangement_System_Backend.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.StudentMangementSystem.Student_Mangement_System_Backend.Model.Student;
import com.example.StudentMangementSystem.Student_Mangement_System_Backend.Repository.StudentRepository;
import com.example.StudentMangementSystem.Student_Mangement_System_Backend.Exception.StudentAlreadyExistException;
import com.example.StudentMangementSystem.Student_Mangement_System_Backend.Exception.StudentNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();  // Corrected to use the repository instance
    }

    @Override
    public Student addStudent(Student student) {
        // Check if the student already exists by email
        if (studentAlreadyExists(student.getEmail())) {
            throw new StudentAlreadyExistException(student.getEmail() + " already exists!");
        }
        return studentRepository.save(student);  // Save the new student
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        // Find the student by ID and update if exists
        return studentRepository.findById(id).map(st -> {
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setEmail(student.getEmail());
            st.setDepartment(student.getDepartment());
            return studentRepository.save(st);  // Save updated student
        }).orElseThrow(() -> new StudentNotFoundException("Sorry, this student could not be found"));
    }

    @Override
    public Student getStudentById(Long id) {
        // Find the student by ID, or throw exception if not found
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Sorry, no student found with the Id :" + id));
    }

    @Override
    public void deleteStudent(Long id) {
        // If student doesn't exist, throw exception
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Sorry, student not found");
        }
        studentRepository.deleteById(id);  // Delete the student
    }

    // Private method to check if a student already exists by email
    private boolean studentAlreadyExists(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }
}