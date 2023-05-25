package com.example.departmentManagement.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.example.departmentManagement.model.Department;
import com.example.departmentManagement.repository.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository depRepo;
    public Department createDepartment(String name,String location)
    {
        Department dep = depRepo.save(new Department(name,location));
        if (dep!=null)
            return dep;
        return null;
    }
    public String updateDepartment(Long id,String name,String location)
    {
        Optional<Department> depOptional = depRepo.findById(id);
        if (depOptional.isPresent())
            {
                Department dep = depRepo.save(new Department(id,name,location));
                return "Department with Id "+dep.getDepartmentId()+" is updated";
            }
        return "Department not found";
    }
    public Optional<Department> getDepartmentById(Long id)
    {
        Optional<Department> dep = depRepo.findById(id);
        if (dep.isPresent())
            return dep;
        return null;
    }
    public ArrayList<Department> getAllDepartments()
    {
        return (ArrayList<Department>)depRepo.findAll();
    }
    public String deleteDepartment(Long id)
    {
        Optional<Department> dep = depRepo.findById(id);
        if (dep.isPresent())
            {
                depRepo.deleteById(id);
                return "Department with Id "+ id +" is successfully deleted";
            }
        return "Department not found";
    }
}
