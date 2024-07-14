/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.iEmploye;
import java.util.List;
import javax.persistence.EntityManager;
import models.Employe;

/**
 *
 * @author Cheikh
 */
public class employeService implements iEmploye {

    private final EntityManager EM;
    public employeService() {
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
}
