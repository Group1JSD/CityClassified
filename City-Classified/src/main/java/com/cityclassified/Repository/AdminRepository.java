package com.cityclassified.Repository;

import com.cityclassified.model.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByAdminEmail(String adminEmail);
}