package com.example.departmentManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.departmentManagement.model.Student;


public interface StudentRepository extends CrudRepository<Student, String> {

    Student save(Student student);

}