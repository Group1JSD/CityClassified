package com.cityclassified.Controller;
import com.cityclassified.Dao.AdminDao;
import com.cityclassified.model.Admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminDao admindao;
	
	@PostMapping("/login")
	//public String adminLogin(@RequestParam String adminEmail, @RequestParam String adminPass) {
	public String adminLogin(@RequestBody Map<String, String> payload) {
        String adminEmail = payload.get("adminEmail");
        String adminPass = payload.get("adminPass");
        //upper three lines is helpful for testing in JSON format in postman
        Admin admin = admindao.authenticateAdmin(adminEmail, adminPass);
        if (admin != null) {
            return "Login successful for admin: " + admin.getAdminEmail();
        } else {
            return "Invalid email or password";
        }
    }
	@PostMapping("/logout")
    public String logout() {
        return "Admin logged out successfully";
    }
}
