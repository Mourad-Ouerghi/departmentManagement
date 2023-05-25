package com.example.departmentManagement.service;

import java.util.ArrayList;
import java.util.Set;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.departmentManagement.model.Student;
import com.example.departmentManagement.model.Class;
import com.example.departmentManagement.repository.StudentRepository;

@Service
public class StudentService{
    @Autowired
    private StudentRepository studentRepo;
    public Student createStudent(String name,String email,String address,Integer age,String gender)
    {
        Student student = studentRepo.save(new Student(name,email,age,gender,address));
        if (student!=null)
            return student;
        return null;
    }
    public String updateStudent(Long id,String name,String email,String address,Integer age,String gender,Set<Class> classes)
    {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isPresent())
            {
                Student student = studentRepo.save(new Student(id,name,email,age,gender,address,classes));
                return "student with Id "+student.getStudentId()+" is updated";
            }
        return "student not found";
    }
    public Optional<Student> getStudentById(Long id)
    {
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent())
            return student;
        return null;
    }
    public ArrayList<Student> getAllStudents()
    {
        return (ArrayList<Student>)studentRepo.findAll();
    }
    public String deleteStudent(Long id)
    {
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent())
            {
                studentRepo.deleteById(id);
                return "student with Id "+ id +" is successfully deleted";
            }
        return "student not found";
    }
}
