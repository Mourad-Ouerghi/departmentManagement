package com.example.departmentManagement.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.departmentManagement.model.Department;


public interface DepartmentRepository extends CrudRepository<Department, String> {
    
}
