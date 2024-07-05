package com.cityclassified.Service;

import com.cityclassified.Repository.UserRepository;
import com.cityclassified.model.Classifieds;
import com.cityclassified.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User authenticateUser(String userEmail, String password) {
        User user = userRepository.findByUserEmail(userEmail);
        if (user!= null && user.getUserPass().equals(password)) {
            return user;
        }
        return null;
    }

    public boolean createUser(User user) {
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(int userId) {
        userRepository.deleteById(userId);
        return true;
    }

    public boolean updatePassword(String password) {
        // implement update password logic
        return false;
    }
    public List<Classifieds> getClassifiedsByUser(Integer userId) {
        User user = getUserId(userId);
        return user.getClassifieds();
    }

	private User getUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public User updateUserId(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Classifieds> getClassifiedsByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
