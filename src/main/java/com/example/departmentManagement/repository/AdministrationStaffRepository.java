package com.example.departmentManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.departmentManagement.model.AdministrationStaff;

@Repository
public interface AdministrationStaffRepository extends CrudRepository<AdministrationStaff,Long> {
    
}
