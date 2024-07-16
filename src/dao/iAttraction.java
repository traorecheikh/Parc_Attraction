/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import models.Attraction;

/**
 *
 * @author Cheikh
 */
public interface iAttraction {
    void addAttraction(Attraction attraction);
    Attraction getAttractionById(int attractionId);
    public Attraction getAttractionByNom(String nom);
    List<Attraction> getAllAttractions();
    void updateAttraction(Attraction attraction);
    void deleteAttraction(Attraction attraction);
}
