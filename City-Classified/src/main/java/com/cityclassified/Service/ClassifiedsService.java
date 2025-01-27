package com.cityclassified.Service;

import com.cityclassified.Repository.ClassifiedsRepository;
import com.cityclassified.model.Classifieds;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifiedsService {
    @Autowired
    private ClassifiedsRepository classifiedsRepository;

    public List<Classifieds> getAllClassifieds() {
        return classifiedsRepository.findAll();
    }
    //@Transactional
    public Classifieds saveClassifieds(Classifieds classifieds) {
    	//classifieds.setUser(null);
    	
        return classifiedsRepository.save(classifieds);
    }

    public List<Classifieds> getAllUserClassifieds(int userId) {
        return classifiedsRepository.findByUser_UserId(userId);
    }

    public boolean addClassified(Classifieds classified) {
        classifiedsRepository.save(classified);
        return true;
    }

    public boolean updateClassified(Classifieds classified) {
        classifiedsRepository.save(classified);
        return true;
    }

    public boolean deleteClassified(int classifiedId) {
        classifiedsRepository.deleteById(classifiedId);
        return true;
    }

    public List<Classifieds> getClassifiedsByUser(int userId) {
        return classifiedsRepository.findByUser_UserId(userId);
    }

    public List<Classifieds> getClassifiedsByCityDetails(String cityName) {
        return classifiedsRepository.findByCityName(cityName);
    }
}
