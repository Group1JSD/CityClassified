package com.cityclassified.Dao;

import com.cityclassified.model.User;

public interface UserDao {
	User authenticateUser(String userName, String userPass);
	boolean createUser(User user);
	boolean deleteUser(int userId);
	boolean updatePassword(String userEmail, String newPass);
}
