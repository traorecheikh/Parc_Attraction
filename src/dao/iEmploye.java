/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import models.Attraction;
import models.Employe;
import models.Horaire;

/**
 *
 * @author Cheikh
 */
public interface iEmploye {
    void addEmploye(Employe employe);

    Employe getEmployeById(int employeId);
    List<Employe> getAllEmployes();
    public void updateEmploye(Employe employe);
    public void deleteEmploye(int employeId);
    public List<Horaire> getAllHoraire();
    public List<Horaire> getAllHoraireByEmployeId(int employeId);
    public String generateCarteEmploye(String nom, String prenom);
    public Employe getEmployeByCarteEmploye(String carteEmploye);
    public boolean assignEmployeToAttraction(Employe employe, Attraction attraction);
    
}
