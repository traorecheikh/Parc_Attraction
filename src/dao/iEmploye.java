/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import models.Employe;
import models.Horaire;

/**
 *
 * @author Cheikh
 */
public interface iEmploye {
    void addEmploye(Employe employe);

    // Read
    Employe getEmployeById(int employeId);
    List<Employe> getAllEmployes();

    // Update
    public void updateEmploye(Employe employe);

    // Delete
    public void deleteEmploye(int employeId);
    public List<Horaire> getAllHoraire();
    
}
