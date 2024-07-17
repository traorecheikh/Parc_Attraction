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

    public boolean assignEmployeToAttraction(Employe employe, Attraction attraction) {// Obtain EntityManager instance from context or injection

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

           transaction.commit(); // Commit the transaction
           return true;
       } catch (Exception e) {
           if (transaction.isActive()) {
               transaction.rollback(); // Rollback transaction if there's an exception
           }
           e.printStackTrace(); // Handle exception appropriately
           return false;
       } finally {
           //EM.close(); // Close EntityManager after use (if not managed by container)
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




}
