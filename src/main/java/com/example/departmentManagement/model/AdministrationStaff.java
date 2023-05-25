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
public class AdministrationStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminStaffId;
    private String name;
    private String email;
    private String gender;
    private String address;
}
