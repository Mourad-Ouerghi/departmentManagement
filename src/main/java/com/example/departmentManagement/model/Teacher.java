package com.example.departmentManagement.model;



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
    private Long teacherId;
    private String name;
    private String email;
    private Integer age;
    private String gender;
    private String address;
    public Teacher(String name, String email, Integer age, String gender, String address) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }
}