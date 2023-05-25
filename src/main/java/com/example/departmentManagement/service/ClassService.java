package com.example.departmentManagement.service;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
import com.example.departmentManagement.model.Class;
import com.example.departmentManagement.model.Student;
import com.example.departmentManagement.repository.ClassRepository;

@Service
public class ClassService {

    @Autowired
    ClassRepository classRepo;

    public Class createClass(Integer numberOfHoursTeached, Integer requiredNumberOfHours, String name, String description)
    {
        Class c = classRepo.save(new Class(numberOfHoursTeached,requiredNumberOfHours,name,description));
        if (c != null)
            return c;
        return null;
    }

    public String updateClass(Long id,Integer numberOfHoursTeached, Integer requiredNumberOfHours, String name, String description, Set<Student> students)
    {
        Optional<Class> cOptional = classRepo.findById(id);
        if (cOptional.isPresent())
            {
                Class c = classRepo.save(new Class(id,numberOfHoursTeached,requiredNumberOfHours,name,description,students));
                return "Class with Id "+c.getClassId()+" is updated";
            }
        return "Class not found";
    }

    public Optional<Class> getClassById(Long id)
    {
        Optional<Class> c = classRepo.findById(id);
        if (c.isPresent())
            return c;
        return null;
    }

    public ArrayList<Class> getAllClasses()
    {
        return (ArrayList<Class>)classRepo.findAll();
    }

    public String deleteClass(Long id)
    {
        Optional<Class> dep = classRepo.findById(id);
        if (dep.isPresent())
            {
                classRepo.deleteById(id);
                return "Class with Id "+ id +" is successfully deleted";
            }
        return "Class not found";
    }
    
}
