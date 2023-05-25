package com.example.departmentManagement.model;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String teacherId;
    private String name;
    private String email;
    private Integer age;
    private String gender;
    private Address address;
}