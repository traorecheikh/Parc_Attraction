/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.iAttraction;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import models.Attraction;

/**
 *
 * @author Cheikh
 */
public class attractionService implements iAttraction {
    
    private final EntityManager em;
    public attractionService() {
        em = EntityManagerUtil.getEMF().createEntityManager();
    }
    
    
    @Override
    public void addAttraction(Attraction attraction) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(attraction);
            et.commit();
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new RuntimeException("Error adding attraction: " + ex.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Attraction getAttractionById(int attractionId) {
        try {
            return em.find(Attraction.class, attractionId);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Attraction> getAllAttractions() {
        try {
            TypedQuery<Attraction> query = em.createQuery("SELECT a FROM Attraction a", Attraction.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void updateAttraction(Attraction attraction) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(attraction);
            et.commit();
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new RuntimeException("Error updating attraction: " + ex.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteAttraction(Attraction attraction) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            attraction = em.merge(attraction); // Ensure the entity is managed before removing
            em.remove(attraction);
            et.commit();
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new RuntimeException("Error deleting attraction: " + ex.getMessage());
        } finally {
            em.close();
        }
    }
    
    public void closeEntityManagerFactory() {
        em.close();
    }
    
}
