package com.cityclassified.Repository;
import com.cityclassified.model.CityDetails;
import com.cityclassified.model.Classifieds;
import com.cityclassified.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ClassifiedsRepository extends JpaRepository<Classifieds, Integer> {
    List<Classifieds> findByClassifiedCategory(String category);
    List<Classifieds> findByCityName(String cityName);
	static boolean addClassified(Classifieds classified) {
		// TODO Auto-generated method stub
		return false;
	}
	List<Classifieds> findByCityName(CityDetails cityDetails);
	List<Classifieds> findByUser_UserId(int user_Id);
}