package com.example.departmentManagement.service;

import java.util.Optional;

import com.example.departmentManagement.model.Teacher;
import com.example.departmentManagement.repository.TeacherRepository;

public class TeacherService {
    private TeacherRepository teacherRepo;
    public Teacher createTeacher(String name,String email, Integer age, String gender, String address)
    {
        Teacher teacher = new Teacher(name,email,age,gender,address);
        teacher = teacherRepo.save(teacher);
        if (teacher != null) 
            return teacher;
        return null;
    }

    public String updateTeacher(Long teacherId,String name,String email, Integer age, String gender, String address)
    {
        Optional<Teacher> teacher = teacherRepo.findById(teacherId);
        if (teacher.isPresent()){

            return("Teacher updated.");
        }
        return("Teacher not found.");
        
    }
    public String deleteTeacher(Long teacherId)
    {
        Optional<Teacher> teacher = teacherRepo.findById(teacherId);
        if (teacher != null){
            
            return "Teacher deleted.";
        }
        return "Teacher not found.";
    }
}
