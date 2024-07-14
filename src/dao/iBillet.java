/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import models.Billet;

/**
 *
 * @author Cheikh
 */
public interface iBillet {
    void addBillet(Billet billet);
    Billet getBilletById(int billetId);
    List<Billet> getAllBillets();
    void updateBillet(Billet billet);
    void deleteBillet(Billet billet);
    
}
