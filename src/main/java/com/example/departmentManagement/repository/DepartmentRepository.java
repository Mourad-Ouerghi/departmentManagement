package com.example.departmentManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.departmentManagement.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
    
}
