/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import models.Utilisateur;

/**
 *
 * @author Cheikh
 */
public interface iUtilisateur {
    // Create
    void addUtilisateur(Utilisateur utilisateur);

    // Read
    Utilisateur getUtilisateurById(int utilisateurId);
    List<Utilisateur> getAllUtilisateurs();

    // Update
    void updateUtilisateur(Utilisateur utilisateur);

    // Delete
    void deleteUtilisateur(Utilisateur utilisateur);
    
     public boolean utilisateurExists(String username, String email);
     public boolean validateUser(String username, String encryptedPassword);
    
}
