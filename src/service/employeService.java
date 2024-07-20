/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.iEmploye;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import models.Attraction;
import models.Billet;
import models.Employe;
import models.Horaire;

/**
 *
 * @author Cheikh
 */
public class employeService implements iEmploye {

    private EntityManager EM;
    public employeService() {
        EM = EntityManagerUtil.getEMF().createEntityManager();
    }
    public void employeServicee() {
        EM = EntityManagerUtil.getEMF().createEntityManager();
    }

        @Override
        public List<Employe> getAllEmployes() {
            return EM.createQuery("SELECT e FROM Employe e", Employe.class).getResultList();
        }

        @Override
        public void addEmploye(Employe employe) {
            employe.setCarteEmploye(generateCarteEmploye(employe.getNom(),employe.getPrenom()));
            EM.getTransaction().begin();
            EM.persist(employe);
            EM.getTransaction().commit();
        }

        @Override
        public void updateEmploye(Employe employe) {
            EM.getTransaction().begin();
            EM.merge(employe);
            EM.getTransaction().commit();
        }

        @Override
        public void deleteEmploye(int employeId) {
            EM.getTransaction().begin();
            Employe employe = EM.find(Employe.class, employeId);
            if (employe != null) {
                EM.remove(employe);
            }
            EM.getTransaction().commit();
        }

        @Override
        public Employe getEmployeById(int employeId) {
            return EM.find(Employe.class, employeId);
        }

    @Override
    public boolean assignEmployeToAttraction(Employe employe, Attraction attraction) {

       EntityTransaction transaction = EM.getTransaction();
       transaction.begin();

       try {
           if (EM == null || !EM.isOpen()) {
            employeServicee();
        }
           employe.setDisponibilite("Non Disponible");
           Horaire horaire = new Horaire();
           horaire.setIDEmploye(employe);
           horaire.setIDAttraction(attraction);
           horaire.setDateDebut(new Date());
           horaire.setDateFin(null);
           attraction.setEtat("en service");

           EM.persist(horaire);
           EM.merge(employe);
           EM.merge(attraction);

           transaction.commit();
           return true;
       } catch (Exception e) {
           if (transaction.isActive()) {
               transaction.rollback();
           }
           e.printStackTrace();
           return false;
       } finally {
           //EM.close();
       }
   }
    @Override
    public List<Horaire> getAllHoraire() {
        try {
            TypedQuery<Horaire> query = EM.createQuery("SELECT b FROM Horaire b", Horaire.class);
            return query.getResultList();
        } finally {
            //EM.close();
        }
    }
    @Override
    public List<Horaire> getAllHoraireByEmployeId(int employeId) {
        TypedQuery<Horaire> query = EM.createQuery("SELECT h FROM Horaire h WHERE h.iDEmploye.iDEmploye = :employeId", Horaire.class);
        query.setParameter("employeId", employeId);
        return query.getResultList();
    }
    
    
    @Override
    public String generateCarteEmploye(String nom, String prenom) {
        Long count = (Long) EM.createQuery("SELECT COUNT(e) FROM Employe e WHERE e.nom = :nom AND e.prenom = :prenom")
                              .setParameter("nom", nom)
                              .setParameter("prenom", prenom)
                              .getSingleResult();

        String carteEmploye = nom + "_" + prenom;
        if (count > 0) {
            carteEmploye += "_" + (count + 1);
        }

        return carteEmploye;
    }
    
    @Override
     public Employe getEmployeByCarteEmploye(String carteEmploye) {
        String jpql = "SELECT e FROM Employe e WHERE e.carteEmploye = :carteEmploye";
        TypedQuery<Employe> query = EM.createQuery(jpql, Employe.class);
        query.setParameter("carteEmploye", carteEmploye);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }






}
