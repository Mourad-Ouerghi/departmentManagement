package com.example.departmentManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.departmentManagement.model.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

}

