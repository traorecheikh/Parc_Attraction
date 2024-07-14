/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.iUtilisateur;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import models.Utilisateur;
import service.EntityManagerUtil;

/**
 *
 * @author Cheikh
 */

public class utilisateurService implements iUtilisateur {

    private final EntityManager EM;

    public utilisateurService() {
        EM = EntityManagerUtil.getEMF().createEntityManager();
    }

    @Override
    public void addUtilisateur(Utilisateur utilisateur) {
        EM.getTransaction().begin();
        EM.persist(utilisateur);
        EM.getTransaction().commit();
    }

    @Override
    public Utilisateur getUtilisateurById(int utilisateurId) {
        return EM.find(Utilisateur.class, utilisateurId);
    }
    
    @Override
    public boolean utilisateurExists(String username, String email) {
        TypedQuery<Long> query = EM.createQuery(
                "SELECT COUNT(u) FROM Utilisateur u WHERE u.nomUtilisateur = :username OR u.email = :email", Long.class);
        query.setParameter("username", username);
        query.setParameter("email", email);
        return query.getSingleResult() > 0;
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return EM.createQuery("SELECT u FROM Utilisateur u", Utilisateur.class).getResultList();
    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {
        EM.getTransaction().begin();
        EM.merge(utilisateur);
        EM.getTransaction().commit();
    }

    @Override
    public void deleteUtilisateur(Utilisateur utilisateur) {
        EM.getTransaction().begin();
        EM.remove(EM.contains(utilisateur) ? utilisateur : EM.merge(utilisateur));
        EM.getTransaction().commit();
    }
    
    @Override
     public boolean validateUser(String username, String encryptedPassword) {
      EntityManager em = EntityManagerUtil.getEMF().createEntityManager();
        boolean isValidUser = false;

        try {
            TypedQuery<Utilisateur> query = em.createQuery(
                "SELECT u FROM Utilisateur u WHERE u.nomUtilisateur = :username AND u.motdepasse = :password",
                Utilisateur.class
            );
            query.setParameter("username", username);
            query.setParameter("password", encryptedPassword);

            Utilisateur utilisateur = query.getSingleResult();

            if (utilisateur != null) {
            // Check if the user is an admin
            if (utilisateur.getEstAdmin()) {
                // Set derniereConnexion to current date and time    
                utilisateur.setDerniereConnexion(new Date());
                em.getTransaction().begin();
                em.merge(utilisateur);
                em.getTransaction().commit();
                isValidUser = true;
            }
            }
        } catch (NoResultException e) {
            isValidUser = false;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }

        return isValidUser;
    }
     

    public void setAdminStatus(int userId, int status) {
        EM.getTransaction().begin();
        Utilisateur user = EM.find(Utilisateur.class, userId);
        if (user != null) {
            user.setEstAdmin(status == 1);
            EM.merge(user);
        }
        EM.getTransaction().commit();
    }

}
