package com.example.departmentManagement.controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.departmentManagement.model.Department;
import com.example.departmentManagement.service.DepartmentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService depService;

    @PostMapping("/addDepartment")
    public Department createDepartment(@RequestBody Department dep)
    {
        return depService.createDepartment(dep.getName(),dep.getLocation());
    }
    @PutMapping("/updateDepartment")
    public String updateDepartment(@RequestBody Department dep)
    {
        return depService.updateDepartment(dep.getDepartmentId(),dep.getName(),dep.getLocation());
    }
    @GetMapping("/getDepartment/{depId}")
    public Optional<Department> getDepartmentById(@PathVariable(name = "depId")Long depId) {
        return depService.getDepartmentById(depId);
    }
    @GetMapping("/getDepartments")
    public ArrayList<Department> getAllDepartments() {
        return depService.getAllDepartments();
    }
    @DeleteMapping("/deleteDepartment/{depId}")
    public String deleteDepartmentById(@PathVariable(name = "depId")Long depId)
    {
        return depService.deleteDepartment(depId);
    }
}
