package com.cityclassified.Dao;
import com.cityclassified.model.Classifieds;
import java.util.List;

public interface ClassifiedsDao {
    List<Classifieds> getAllClassifieds();
    List<Classifieds> getAllUserClassifieds(int userId);
    boolean addClassified(Classifieds classified);
    boolean updateClassified(Classifieds classified);
    boolean deleteClassified(int classFieldId);
    boolean deleteAllUserClassified(int userId);
    List<Classifieds> searchClassified(String keyword);
    List<Classifieds> filterClassifiedByCity(String city);
    List<Classifieds> filterClassifiedByCategory(String category);
}
