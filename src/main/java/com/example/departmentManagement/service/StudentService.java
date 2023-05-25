package com.example.departmentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.departmentManagement.model.Student;
import com.example.departmentManagement.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepo;
    public String createStudent( )
    {
        Student student = new Student(name,email,age,gender,address);
        Student student = studentRepo.save(student);
    }
}
