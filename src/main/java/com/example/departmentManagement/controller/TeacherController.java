package com.example.departmentManagement.controller;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.departmentManagement.service.TeacherService;
import com.example.departmentManagement.model.Teacher;



@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/addTeacher")
    public Teacher createTeacher(@RequestBody Teacher teacher)
    {
        return teacherService.createTeacher(teacher.getName(),teacher.getEmail(), teacher.getAge(),teacher.getGender(),teacher.getAddress());
    }
    @PutMapping("/updateTeacher")
    public String updateTeacher(@RequestBody Teacher teacher)
    {
        return teacherService.updateTeacher(teacher.getTeacherId(),teacher.getName(),teacher.getEmail(), teacher.getAge(),teacher.getGender(),teacher.getAddress());
    }
    @GetMapping("/getTeacher/{teacherId}")
    public Optional<Teacher> getTeacherById(@PathVariable(name = "teacherId")Long teacherId) {
        return teacherService.getTeacherById(teacherId);
    }
    @GetMapping("/getTeacher")
    public ArrayList<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }
    @DeleteMapping("/deleteTeacher/{teacherId}")
    public String deleteTeacherById(@PathVariable(name = "teacherId")Long teacherId)
    {
        return teacherService.deleteTeacher(teacherId);
    }
}
