package com.cityclassified.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cityclassified.Dao.UserDao;
import com.cityclassified.model.User;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserDao userDao;
	
	@PostMapping("/login")
	public String userLogin(@RequestParam String userName, @RequestParam String userPass) {
        User user = userDao.authenticateUser(userName, userPass);
        if (user != null) {
            return "Login successful for user: " + user.getUserName();
        } else {
            return "Invalid username or password";
        }
    }
	@PostMapping("/logout")
    public String logout() {
        return "User logged out successfully";
    }
	@PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        boolean isCreated = userDao.createUser(user);
        if (isCreated) {
            return "User registered successfully";
        } else {
            return "User registration failed: Email already in use";
        }
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId) {
        boolean isDeleted = userDao.deleteUser(userId);
        if (isDeleted) {
            return "User deleted successfully";
        } else {
            return "User deletion failed: User not found";
        }
    }
    @GetMapping("/test")
    public String test() {
        return "Application is running";
        //this code is for testing purpose only
    }
}
