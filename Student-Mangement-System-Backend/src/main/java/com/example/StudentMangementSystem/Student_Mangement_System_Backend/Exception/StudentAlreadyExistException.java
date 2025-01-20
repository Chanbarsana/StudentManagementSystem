package com.example.StudentMangementSystem.Student_Mangement_System_Backend.Exception;

public class StudentAlreadyExistException extends RuntimeException {
    public StudentAlreadyExistException(String message) {
        super(message);
    }
}
