package com.cityclassified.Controller;

import com.cityclassified.Service.*;
import com.cityclassified.model.Classifieds;
import com.cityclassified.model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User authenticatedUser = userService.authenticateUser(user.getUserEmail(), user.getUserPass());
        if (authenticatedUser != null) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }

    @PostMapping("/register")
    public boolean registerUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        user.setUserId(id);
        return userService.updateUserId(user);
    }

    @DeleteMapping("/{userId}")
    public boolean deleteUser(@PathVariable int userId) {
        return userService.deleteUser(userId);
    }
    @GetMapping("/{id}/classifieds")
    public List<Classifieds> getClassifiedsByUser(@PathVariable int id) {
        return userService.getClassifiedsByUserId(id);
    }
}