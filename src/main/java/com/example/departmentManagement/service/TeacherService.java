package com.example.departmentManagement.service;

import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.departmentManagement.model.Teacher;
import com.example.departmentManagement.repository.TeacherRepository;

@Service
public class TeacherService {
    @Autowired
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
        Optional<Teacher> teacherOptional = teacherRepo.findById(teacherId);
        if (teacherOptional.isPresent())
        {
            Teacher teacher = teacherRepo.save(new Teacher(teacherId,name,email,age,gender,address));
            return "Teacher with Id "+teacher.getTeacherId()+" is updated";
        }
        return("Teacher not found.");
        
    }
    public Optional<Teacher> getTeacherById(Long id)
    {
        Optional<Teacher> teacher = teacherRepo.findById(id);
        if (teacher.isPresent())
            return teacher;
        return null;
    }
    public ArrayList<Teacher> getAllTeachers()
    {
        return (ArrayList<Teacher>)teacherRepo.findAll();
    }
    public String deleteTeacher(Long id)
    {
        Optional<Teacher> teacher = teacherRepo.findById(id);
        if (teacher.isPresent())
            {
                teacherRepo.deleteById(id);
                return "teacher with Id "+ id +" is successfully deleted";
            }
        return "teacher not found";
    }
}
