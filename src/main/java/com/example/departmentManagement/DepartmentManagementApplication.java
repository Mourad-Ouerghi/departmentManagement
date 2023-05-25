package com.example.departmentManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.departmentManagement","com.example.departmentManagement.repository.StudentRepository"})
public class DepartmentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentManagementApplication.class, args);
	}

}
