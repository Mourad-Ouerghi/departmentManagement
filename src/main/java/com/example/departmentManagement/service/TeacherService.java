package com.example.departmentManagement.service;

import com.example.departmentManagement.model.Teacher;
import com.example.departmentManagement.repository.TeacherRepository;

public class TeacherService {
    private TeacherRepository teacherRepo;
    public String createTeacher(String name,String email, Integer age, String gender, String address)
    {
        Teacher teacher = new Teacher(name,email,age,gender,address);
        teacher = teacherRepo.save(teacher);
        if (teacher != null) 
        {
            return(teacher.getTeacherId());
        }
        return ("Error teacher creation.");
    }

    public String updateTeacher(String teacherId,String name,String email, Integer age, String gender, String address)
    {
        Teacher teacher = teacherRepo.findById(teacherId);
        if (teacher != null){
            teacher.setName(name);
            teacher.setEmail(email);
            teacher.setAddress(address);
            teacher.setAge(age);
            teacher.setGender(gender);
            return("Teacher updated.");
        }
        return("Teacher not found.");
        
    }
    public String deleteTeacher(String teacherId)
    {
        Teacher teacher = teacherRepo.findById(teacherId);
        if (teacher != null){
            
            return("Teacher deleted.");
        }
        return("Teacher not found.");
    }
}
