package com.cityclassified.Dao.Imp;

import com.cityclassified.Dao.ClassifiedsDao;
import com.cityclassified.model.Classifieds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ClassifiedsDaoImp implements ClassifiedsDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Classifieds> getAllClassifieds() {
        TypedQuery<Classifieds> query = entityManager.createQuery("SELECT c FROM Classifieds c", Classifieds.class);
        return query.getResultList();
    }

    @Override
    public List<Classifieds> getAllUserClassifieds(int userId) {
        TypedQuery<Classifieds> query = entityManager.createQuery("SELECT c FROM Classifieds c WHERE c.userId = :userId", Classifieds.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public boolean addClassified(Classifieds classified) {
        try {
            entityManager.persist(classified);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateClassified(Classifieds classified) {
        try {
            entityManager.merge(classified);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteClassified(int classFieldId) {
        try {
            Classifieds classified = entityManager.find(Classifieds.class, classFieldId);
            if (classified != null) {
                entityManager.remove(classified);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteAllUserClassified(int userId) {
        try {
            TypedQuery<Classifieds> query = entityManager.createQuery("SELECT c FROM Classifieds c WHERE c.userId = :userId", Classifieds.class);
            query.setParameter("userId", userId);
            List<Classifieds> classifieds = query.getResultList();
            for (Classifieds classified : classifieds) {
                entityManager.remove(classified);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Classifieds> searchClassified(String keyword) {
        TypedQuery<Classifieds> query = entityManager.createQuery("SELECT c FROM Classifieds c WHERE c.classifiedTitle LIKE :keyword OR c.userName LIKE :keyword", Classifieds.class);
        query.setParameter("keyword", "%" + keyword + "%");
        return query.getResultList();
    }

    @Override
    public List<Classifieds> filterClassifiedByCity(String city) {
        TypedQuery<Classifieds> query = entityManager.createQuery("SELECT c FROM Classifieds c WHERE c.userCity = :city", Classifieds.class);
        query.setParameter("city", city);
        return query.getResultList();
    }

    @Override
    public List<Classifieds> filterClassifiedByCategory(String category) {
        TypedQuery<Classifieds> query = entityManager.createQuery("SELECT c FROM Classifieds c WHERE c.classifiedCategory = :category", Classifieds.class);
        query.setParameter("category", category);
        return query.getResultList();
    }
}
