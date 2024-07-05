package com.cityclassified.Controller;

import com.cityclassified.Repository.ClassifiedsRepository;
import com.cityclassified.Service.*;
import com.cityclassified.model.Classifieds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classifieds")
public class ClassifiedsController {
    @Autowired
    private ClassifiedsService classifiedsService;

    @GetMapping
    public List<Classifieds> getAllClassifieds() {
        return classifiedsService.getAllClassifieds();
    }

    @GetMapping("/{userId}")
    public List<Classifieds> getAllUserClassifieds(@PathVariable int userId) {
        return classifiedsService.getAllUserClassifieds(userId);
    }

    @PostMapping("/add")
    public Classifieds addClassified(@RequestBody Classifieds classified) {
    	boolean isSuccess = ClassifiedsRepository.addClassified(classified);
        return classified;
    }

    @PutMapping("/{classifiedId}")
    public boolean updateClassified(@PathVariable int classifiedId, @RequestBody Classifieds classified) {
        return classifiedsService.updateClassified(classified);
    }

    @DeleteMapping("/{classifiedId}")
    public boolean deleteClassified(@PathVariable int classifiedId) {
        return classifiedsService.deleteClassified(classifiedId);
    }
    @GetMapping("/user/{userId}")
    public List<Classifieds> getClassifiedsByUser(@PathVariable int userId) {
        return classifiedsService.getClassifiedsByUser(userId);
    }

    @GetMapping("/cityDetails/{cityName}")
    public List<Classifieds> getClassifiedsByCityDetails(@PathVariable String cityName) {
        return classifiedsService.getClassifiedsByCityDetails(cityName);
    }
}