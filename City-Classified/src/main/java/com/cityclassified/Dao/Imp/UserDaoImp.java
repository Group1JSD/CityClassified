package com.cityclassified.Dao.Imp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cityclassified.Dao.UserDao;
import com.cityclassified.model.User;

@Repository
public class UserDaoImp implements UserDao{
	private Map<Integer, User> userDatabase = new HashMap<>();
	private int userIdCounter=1;
	
	@Override
	public User authenticateUser(String userName, String userPass) {
		return userDatabase.values().stream().filter(user -> user.getUserName().equals(userName) && user.getUserPass().equals(userPass)).findFirst().orElse(null);
	}
	
	@Override
	public boolean createUser(User user) {
		if(userDatabase.values().stream().anyMatch(u ->u.getUserEmail().equals(user.getUserEmail()))) {
			return false;
		}
		user.setUserId(userIdCounter++);
		userDatabase.put(user.getUserId(),user);
		return true;
	}
	
	@Override
	public boolean deleteUser(int userId) {
		return userDatabase.remove(userId)!=null;
	}
	
	@Override
	public boolean updatePassword(String userEmail, String newPass) {
		User user=userDatabase.values().stream().filter(u->u.getUserEmail().equals(userEmail)).findFirst().orElse(null);
		if(user == null) {
			return false;
		}
		user.setUserPass(newPass);
		return true;
	}

}
