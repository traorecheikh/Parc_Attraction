/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.iBillet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import models.Billet;

/**
 *
 * @author Cheikh
 */
public class billetService implements iBillet {

    private EntityManager em;
    public billetService() {
        this.em = EntityManagerUtil.getEMF().createEntityManager(); 
    }
    public void billetServicee() {
        em = EntityManagerUtil.getEMF().createEntityManager();
    }
    

    @Override
    public void addBillet(Billet billet) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(billet);
            et.commit();
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new RuntimeException("Error adding billet: " + ex.getMessage());
        } finally {
            //em.close();
        }
    }

    @Override
    public Billet getBilletById(int billetId) {
        try {
            return em.find(Billet.class, billetId);
        } finally {
           // em.close();
        }
    }

    @Override
    public List<Billet> getAllBillets() {
        try {
            TypedQuery<Billet> query = em.createQuery("SELECT b FROM Billet b", Billet.class);
            return query.getResultList();
        } finally {
            //em.close();
        }
    }

    @Override
    public void updateBillet(Billet billet) {
        em = EntityManagerUtil.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {

            et.begin();
            em.merge(billet);
            et.commit();
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new RuntimeException("Error updating billet: " + ex.getMessage());
        } finally {
            //em.close();
        }
    }

    @Override
    public void deleteBillet(Billet billet) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            billet = em.merge(billet); // Ensure the entity is managed before removing
            em.remove(billet);
            et.commit();
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new RuntimeException("Error deleting billet: " + ex.getMessage());
        } finally {
            em.close();
        }
    }
    
    public void closeEntityManagerFactory() {
        em.close();
    }
    
}
