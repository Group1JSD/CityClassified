package com.cityclassified.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cityclassified.Service.AdminService;
import com.cityclassified.model.Admin;
import com.cityclassified.model.CityDetails;
import com.cityclassified.model.User;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

//    @PostMapping("/login")
//    public String login(@RequestBody Admin admin) {
//        Admin authenticatedAdmin = adminService.authenticateAdmin(admin.getAdminEmail(), admin.getAdminPass());
//        if (authenticatedAdmin!= null) {
//            return "Login successful";
//        } else {
//            return "Invalid credentials";
//        }
//    }
    @PostMapping("/login")
    public String login(@RequestBody Admin admin) {
        Admin authenticatedAdmin = adminService.authenticateAdmin(admin.getAdminEmail(), admin.getAdminPass());
        if (authenticatedAdmin != null) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }
    @GetMapping("/{id}/city-details")
    public List<CityDetails> getCityDetailsByAdminId(@PathVariable int adminId) {
        return adminService.getCityDetailsByAdmin(adminId);
    }
}