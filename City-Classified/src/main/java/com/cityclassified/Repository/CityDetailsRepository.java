package com.cityclassified.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cityclassified.model.Admin;
import com.cityclassified.model.CityDetails;

public interface CityDetailsRepository extends JpaRepository<CityDetails, Integer> {
    List<CityDetails> findByCity(String city);
    List<CityDetails> findByCategory(String category);
	List<CityDetails> findByAdmin_AdminId(Admin adminId);
}
