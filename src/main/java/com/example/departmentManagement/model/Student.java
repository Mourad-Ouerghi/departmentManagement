package com.example.departmentManagement.model;

import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String name;
    private String email;
    private Integer age;
    private String gender;
    private String address;
    public Student(String name, String email, Integer age, String gender, String address) 
    {
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }
    @ManyToMany
    @JoinTable(
        name="classDetails",
        joinColumns = @JoinColumn(name="studentId"),
        inverseJoinColumns = @JoinColumn(name="classId")
    )
    Set<Class> enrolledClasses;
}