package com.example.departmentManagement.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.departmentManagement.model.Class;

@Repository
public interface ClassRepository extends CrudRepository<Class,Long> {
}
    
