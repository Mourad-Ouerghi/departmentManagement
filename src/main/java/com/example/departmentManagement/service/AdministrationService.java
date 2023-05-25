package com.example.departmentManagement.service;

import java.util.ArrayList;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.departmentManagement.model.AdministrationStaff;
import com.example.departmentManagement.repository.AdministrationStaffRepository;

@Service
public class AdministrationService{
    @Autowired
    private AdministrationStaffRepository administrationRepo;
    public AdministrationStaff createAdministrationStaff(String name,String email,String address,Integer age,String gender)
    {
        AdministrationStaff administration = administrationRepo.save(new AdministrationStaff(name,email,age,gender,address));
        if (administration!=null)
            return administration;
        return null;
    }
    public String updateAdministrationStaff(Long id,String name,String email,String address,Integer age,String gender)
    {
        Optional<AdministrationStaff> administrationOptional = administrationRepo.findById(id);
        if (administrationOptional.isPresent())
            {
                AdministrationStaff administrationStaff = administrationRepo.save(new AdministrationStaff(id,name,email,age,gender,address));
                return "Administration Staff with Id "+ administrationStaff.getAdminStaffId()+" is updated";
            }
        return "Administration Staff not found";
    }
    public Optional<AdministrationStaff> getAdministrationStaffById(Long id)
    {
        Optional<AdministrationStaff> administrationStaff = administrationRepo.findById(id);
        if (administrationStaff.isPresent())
            return administrationStaff;
        return null;
    }
    public ArrayList<AdministrationStaff> getAllAdministrationStaff()
    {
        return (ArrayList<AdministrationStaff>)administrationRepo.findAll();
    }
    public String deleteAdministrationStaff(Long id)
    {
        Optional<AdministrationStaff> administrationStaff = administrationRepo.findById(id);
        if (administrationStaff.isPresent())
            {
                administrationRepo.deleteById(id);
                return "Administration Staff with Id "+ id +" is successfully deleted";
            }
        return "Administration not found";
    }
}