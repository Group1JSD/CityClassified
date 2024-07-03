package com.cityclassified.Controller;

import com.cityclassified.Dao.ClassifiedsDao;
import com.cityclassified.model.Classifieds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classifieds")
public class ClassifiedsController {

    @Autowired
    private ClassifiedsDao classifiedsDao;

    @GetMapping("/all")
    public List<Classifieds> getClassifieds() {
        return classifiedsDao.getAllClassifieds();
    }

    @GetMapping("/user/{userId}")
    public List<Classifieds> getUserClassifieds(@PathVariable int userId) {
        return classifiedsDao.getAllUserClassifieds(userId);
    }

    @GetMapping("/search")
    public List<Classifieds> searchClassifieds(@RequestParam String keyword) {
        return classifiedsDao.searchClassified(keyword);
    }

    @GetMapping("/filter/city")
    public List<Classifieds> filterClassifiedsCity(@RequestParam String city) {
        return classifiedsDao.filterClassifiedByCity(city);
    }

    @GetMapping("/filter/category")
    public List<Classifieds> filterClassifiedsCategory(@RequestParam String category) {
        return classifiedsDao.filterClassifiedByCategory(category);
    }

    @PostMapping("/add")
    public String addClassified(@RequestBody Classifieds classified) {
        boolean isSuccess = classifiedsDao.addClassified(classified);
        return isSuccess ? "Classified added successfully" : "Failed to add classified";
    }

    @PutMapping("/update")
    public String updateClassified(@RequestBody Classifieds classified) {
        boolean isSuccess = classifiedsDao.updateClassified(classified);
        return isSuccess ? "Classified updated successfully" : "Failed to update classified";
    }

    @DeleteMapping("/delete/{classFieldId}")
    public String deleteClassified(@PathVariable int classFieldId) {
        boolean isSuccess = classifiedsDao.deleteClassified(classFieldId);
        return isSuccess ? "Classified deleted successfully" : "Failed to delete classified";
    }
}
