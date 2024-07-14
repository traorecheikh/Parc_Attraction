/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.iClient;
import java.util.List;
import javax.persistence.EntityManager;
import models.Client;

/**
 *
 * @author Cheikh
 */
public class clientService implements iClient {
    
    private final EntityManager EM;
    public clientService() {
        EM = EntityManagerUtil.getEMF().createEntityManager();
    }

    @Override
    public void addClient(Client client) {
        try {
            EM.getTransaction().begin();
            EM.persist(client);
            EM.getTransaction().commit();
        } catch (Exception ex) {
            EM.getTransaction().rollback();
            throw new RuntimeException("Error adding client: " + ex.getMessage());
        }
    }

    @Override
    public Client getClientById(int clientId) {
        return EM.find(Client.class, clientId);
    }


    @Override
    public List<Client> getAllClients() {
        return EM.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }


    @Override
    public void updateClient(Client client) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteClient(Client client) {
        try {
            EM.getTransaction().begin();
            client = EM.merge(client); // Ensure the entity is managed before removing
            EM.remove(client);
            EM.getTransaction().commit();
        } catch (Exception ex) {
            EM.getTransaction().rollback();
            throw new RuntimeException("Error deleting client: " + ex.getMessage());
        }
    }

    
}
