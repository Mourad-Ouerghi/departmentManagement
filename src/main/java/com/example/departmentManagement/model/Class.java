package com.example.departmentManagement.model;

import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="classId")
    private Long classId;
    private Integer numberOfHoursTeached;
    private Integer requiredNumberOfHours;
    private String name;
    private String description;
    public Class(Integer numberOfHoursTeached, Integer requiredNumberOfHours, String name, String description) {
        this.numberOfHoursTeached = numberOfHoursTeached;
        this.requiredNumberOfHours = requiredNumberOfHours;
        this.name = name;
        this.description = description;
    }
    @ManyToMany(mappedBy = "enrolledClasses")
    Set<Student> enrolls;
}
