package com.example.departmentManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.departmentManagement.model.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}