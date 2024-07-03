package com.cityclassified.Dao.Imp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cityclassified.Dao.AdminDao;
import com.cityclassified.model.Admin;
@Repository
public class AdminDaoImp implements AdminDao{
	private Map<Integer, Admin> adminDatabase= new HashMap<>();
	private int adminIdCounter=1;
	
	public AdminDaoImp() {
        
        Admin admin = new Admin();
        admin.setAdminId(adminIdCounter++);
        admin.setAdminEmail("mrkhan@gmail.com");
        admin.setAdminPass("admin123");
        adminDatabase.put(admin.getAdminId(), admin);
    }
	
	@Override
	public Admin authenticateAdmin(String adminEmail, String adminPass) {
		return adminDatabase.values().stream().filter(admin-> admin.getAdminEmail().equals(adminEmail) && admin.getAdminPass().equals(adminPass)).findFirst().orElse(null);
	}
	
	@Override
	public boolean updatePassword(String adminEmail, String newPassword) {
		Admin admin=adminDatabase.values().stream().filter(a-> a.getAdminEmail().equals(adminEmail)).findFirst().orElse(null);
		if(admin== null) {
			return false;
		}
		admin.setAdminPass(newPassword);
		return true;
	}
}
