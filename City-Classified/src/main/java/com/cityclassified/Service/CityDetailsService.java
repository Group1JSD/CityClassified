package com.cityclassified.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cityclassified.Repository.AdminRepository;
import com.cityclassified.Repository.CityDetailsRepository;
import com.cityclassified.model.Admin;
import com.cityclassified.model.CityDetails;
import com.cityclassified.model.Classifieds;

@Service
public class CityDetailsService {
    @Autowired
    private CityDetailsRepository cityDetailsRepository;
//    @Autowired
//    private AdminRepository adminRepository;
//    public CityDetails addCityDetails(int adminId, CityDetails cityDetails) {
//        Admin admin = adminRepository.findById(adminId)
//                                     .orElseThrow(() -> new RuntimeException("Admin not found"));
//
//        cityDetails.setAdmin(admin);
//
//        cityDetailsRepository.save(cityDetails);
//        return cityDetails;
//    }
    
    public List<CityDetails> getAllCityDetails() {
        return cityDetailsRepository.findAll();
    }

    public CityDetails addCityDetails(CityDetails cityDetails) {
        cityDetailsRepository.save(cityDetails);
        return cityDetails;
    }

    public boolean updateCityDetails(CityDetails cityDetails) {
        cityDetailsRepository.save(cityDetails);
        return true;
    }

    public boolean deleteCityDetails(int cityId) {
        cityDetailsRepository.deleteById(cityId);
        return true;
    }
    public List<CityDetails> getCityDetailsByAdmin(int adminId) {
        return cityDetailsRepository.findByAdmin_AdminId(new Admin(adminId));
    }

    public List<Classifieds> getClassifiedsByCityDetails(int cityId) {
        CityDetails cityDetails = getCityDetailsById(cityId);
        return cityDetails.getClassifieds();
    }

	private CityDetails getCityDetailsById(int cityId) {
		// TODO Auto-generated method stub
		return null;
	}
}
