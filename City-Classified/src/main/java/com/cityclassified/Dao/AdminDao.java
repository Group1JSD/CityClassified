package com.cityclassified.Dao;

import com.cityclassified.model.Admin;

public interface AdminDao {
	Admin authenticateAdmin(String adminEmail, String adminPass);
    boolean updatePassword(String adminEmail, String newPassword);
}
