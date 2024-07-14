/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import models.Client;

/**
 *
 * @author Cheikh
 */
public interface iClient {
    // Create
    void addClient(Client client);

    // Read
    Client getClientById(int clientId);
    List<Client> getAllClients();

    // Update
    void updateClient(Client client);

    // Delete
    void deleteClient(Client client);
}
