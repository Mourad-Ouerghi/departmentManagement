package com.example.departmentManagement.controller;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.departmentManagement.service.AdministrationService;
import com.example.departmentManagement.model.AdministrationStaff;



@RestController
public class AdministrationStaffController {
    @Autowired
    private AdministrationService administrationService;

    @PostMapping("/addAdminStaff")
    public AdministrationStaff createAdministrationStaff(@RequestBody AdministrationStaff administrationStaff)
    {
        return administrationService.createAdministrationStaff(administrationStaff.getName(),administrationStaff.getEmail(),administrationStaff.getAddress(), administrationStaff.getAge(),administrationStaff.getGender());
    }
    @PutMapping("/updateAdminStaff")
    public String updateAdministrationStaff(@RequestBody AdministrationStaff administrationStaff)
    {
        return administrationService.updateAdministrationStaff(administrationStaff.getAdminStaffId(),administrationStaff.getName(),administrationStaff.getEmail(),administrationStaff.getAddress(), administrationStaff.getAge(),administrationStaff.getGender());
    }
    @GetMapping("/getAdministrationStaff/{adminStaffId}")
    public Optional<AdministrationStaff> getAdministrationById(@PathVariable(name = "adminStaffId")Long adminStaffId) {
        return administrationService.getAdministrationStaffById(adminStaffId);
    }
    @GetMapping("/getAdminStaff")
    public ArrayList<AdministrationStaff> getAllAdministrationStaff() {
        return administrationService.getAllAdministrationStaff();
    }
    @DeleteMapping("/deleteAdminStaff/{adminStaffId}")
    public String deleteAdministrationStaffById(@PathVariable(name = "adminStaffId")Long adminStaffId)
    {
        return administrationService.deleteAdministrationStaff(adminStaffId);
    }
}
