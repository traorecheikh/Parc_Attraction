/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Cheikh
 */
@Entity
@Table(name = "client")
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIDClient", query = "SELECT c FROM Client c WHERE c.iDClient = :iDClient"),
    @NamedQuery(name = "Client.findByNom", query = "SELECT c FROM Client c WHERE c.nom = :nom"),
    @NamedQuery(name = "Client.findByPrenom", query = "SELECT c FROM Client c WHERE c.prenom = :prenom"),
    @NamedQuery(name = "Client.findByAge", query = "SELECT c FROM Client c WHERE c.age = :age"),
    @NamedQuery(name = "Client.findByContact", query = "SELECT c FROM Client c WHERE c.contact = :contact")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_Client")
    private Integer iDClient;
    @Basic(optional = false)
    @Column(name = "Nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "Prenom")
    private String prenom;
    @Column(name = "Age")
    private Integer age;
    @Column(name = "Contact")
    private String contact;
    @OneToMany(mappedBy = "iDClient", fetch = FetchType.LAZY)
    private List<Billet> billetList;

    public Client() {
    }

    public Client(Integer iDClient) {
        this.iDClient = iDClient;
    }

    public Client(String nom, String prenom, Integer age, String contact) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.contact = contact;
    }

    public Integer getIDClient() {
        return iDClient;
    }

    public void setIDClient(Integer iDClient) {
        this.iDClient = iDClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Billet> getBilletList() {
        return billetList;
    }

    public void setBilletList(List<Billet> billetList) {
        this.billetList = billetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDClient != null ? iDClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.iDClient == null && other.iDClient != null) || (this.iDClient != null && !this.iDClient.equals(other.iDClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return prenom;
    }
    
}
