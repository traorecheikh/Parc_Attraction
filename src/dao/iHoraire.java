/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import models.Horaire;

/**
 *
 * @author Cheikh
 */
public interface iHoraire {
    // Create
    void addHoraire(Horaire horaire);

    // Read
    Horaire getHoraireById(int horaireId);
    List<Horaire> getAllHoraires();

    // Update
    void updateHoraire(Horaire horaire);

    // Delete
    void deleteHoraire(Horaire horaire);
    
}
