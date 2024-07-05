package com.cityclassified.Repository;

import com.cityclassified.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserEmail(String userEmail);
}