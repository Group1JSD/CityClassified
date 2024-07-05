package com.cityclassified.Service;

import com.cityclassified.Repository.AdminRepository;
import com.cityclassified.model.Admin;
import com.cityclassified.model.CityDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public static final String PERMANENT_ADMIN_EMAIL = "mrkhan@gmail.com";
    public static final String PERMANENT_ADMIN_PASSWORD = "admin123";

    public Admin authenticateAdmin(String adminEmail, String adminPass) {
        if (adminEmail.equals(PERMANENT_ADMIN_EMAIL) && adminPass.equals(PERMANENT_ADMIN_PASSWORD)) {
            return new Admin(PERMANENT_ADMIN_EMAIL, PERMANENT_ADMIN_PASSWORD);
        }
        return null;
    }
    public List<CityDetails> getCityDetailsByAdmin(Integer adminId) {
        Admin admin = getAdminId(adminId);
        return admin.getCityDetails();
    }
	private Admin getAdminId(Integer adminId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}