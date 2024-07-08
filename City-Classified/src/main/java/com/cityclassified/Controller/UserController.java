package com.cityclassified.Controller;

import com.cityclassified.Exception.UserNotFoundException;
import com.cityclassified.Service.*;
import com.cityclassified.model.Classifieds;
import com.cityclassified.model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable int userId, @RequestBody User user) {
        try {
            user.setUserId(userId);
            User updatedUser = userService.updateUser(user);
            return ResponseEntity.ok(updatedUser);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
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