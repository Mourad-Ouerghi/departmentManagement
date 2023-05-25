package com.example.departmentManagement.controller;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.departmentManagement.model.Student;
import com.example.departmentManagement.service.StudentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public Student createStudent(@RequestBody Student student)
    {
        return studentService.createStudent(student.getName(),student.getEmail(),student.getAddress(), student.getAge(),student.getGender());
    }
    @PutMapping("/updateStudent")
    public String updateStudent(@RequestBody Student student)
    {
        return studentService.updateStudent(student.getStudentId(),student.getName(),student.getEmail(),student.getAddress(), student.getAge(),student.getGender());
    }
    @GetMapping("/getStudent/{studentId}")
    public Optional<Student> getStudentById(@PathVariable(name = "studentId")Long studentId) {
        return studentService.getStudentById(studentId);
    }
    // @GetMapping("/getStudent/{studentName}")
    // public ArrayList<Student> getStudentById(@PathVariable(name = "studentName")String studentName ) 
    // {
    //     return studentService.getStudentsByName(studentName);
    // }
    @GetMapping("/getStudents")
    public ArrayList<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    @DeleteMapping("/deleteStudent/{studentId}")
    public String deleteStudentById(@PathVariable(name = "studentId")Long studentId)
    {
        return studentService.deleteStudent(studentId);
    }
}
