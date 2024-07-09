package com.cityclassified.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cityclassified.Service.CityDetailsService;
import com.cityclassified.model.CityDetails;
import com.cityclassified.model.Classifieds;

@RestController
@RequestMapping("/citydetails")
public class CityDetailsController {
    @Autowired
    private CityDetailsService cityDetailsService;

    @GetMapping("/all")
    public List<CityDetails> getAllCityDetails() {
        return cityDetailsService.getAllCityDetails();
    }

//    @PostMapping("/addCity")
//    public CityDetails addCityDetails(@RequestBody CityDetails cityDetails) {
//        return cityDetailsService.addCityDetails(0, cityDetails);
//    }
    @PostMapping("/addCity")
    public CityDetails addCityDetails(@RequestBody CityDetails cityDetails) {
        return cityDetailsService.addCityDetails(cityDetails);
    }


    @PutMapping("/{cityId}")
    public boolean updateCityDetails(@PathVariable int cityId, @RequestBody CityDetails cityDetails) {
        return cityDetailsService.updateCityDetails(cityDetails);
    }

    @DeleteMapping("/{cityId}")
    public boolean deleteCityDetails(@PathVariable int cityId) {
        return cityDetailsService.deleteCityDetails(cityId);
    }
    @GetMapping("/admin/{adminId}")
    public List<CityDetails> getCityDetailsByAdmin(@PathVariable int adminId) {
        return cityDetailsService.getCityDetailsByAdmin(adminId);
    }

    @GetMapping("/{id}/classifieds")
    public List<Classifieds> getClassifiedsByCityDetails(@PathVariable int cityId) {
        return cityDetailsService.getClassifiedsByCityDetails(cityId);
    }
}