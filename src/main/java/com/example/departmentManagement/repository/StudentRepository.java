package com.example.departmentManagement.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.departmentManagement.model.Student;

import java.util.ArrayList;



@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}