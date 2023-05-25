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
import com.example.departmentManagement.model.Class;
import com.example.departmentManagement.service.ClassService;

@RestController
public class ClassController {
    @Autowired
    ClassService classService;

    @PostMapping("/addClass")
    public Class createDepartment(@RequestBody Class c)
    {
        return classService.createClass(c.getNumberOfHoursTeached(),c.getRequiredNumberOfHours(),c.getDescription(),c.getName());
    }
    @PutMapping("/updateClass")
    public String updateClass(@RequestBody Class c)
    {
        return classService.updateClass(c.getClassId(),c.getNumberOfHoursTeached(),c.getRequiredNumberOfHours(),c.getDescription(),c.getName(),c.getEnrolls());
    }
    @GetMapping("/getClass/{classId}")
    public Optional<Class> getClassById(@PathVariable(name = "classId")Long classId) {
        return classService.getClassById(classId);
    }
    @GetMapping("/getClasses")
    public ArrayList<Class> getAllClasses() {
        return classService.getAllClasses();
    }
    @DeleteMapping("/deleteClass/{classId}")
    public String deleteClassById(@PathVariable(name = "classId")Long classId)
    {
        return classService.deleteClass(classId);
    }
}
