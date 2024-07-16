/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Cheikh
 */


@Entity
@Table(name = "billet")
@NamedQueries({
    // Named queries here
})
public class Billet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Billet")
    private Integer iDBillet;

    @Column(name = "Type_Billet")
    private String typeBillet;

    @Column(name = "Prix")
    private double prix;

    @Column(name = "Date_Emission")
    @Temporal(TemporalType.DATE)
    private Date dateEmission;

    @Column(name = "Etat")
    private String etat;

    @Column(name = "ID_Client")  // Store only ID_Client
    private Integer iDClient;

    @Column(name = "ID_Attraction")  // Store only ID_Attraction
    private Integer iDAttraction;

    // Constructors, getters, setters, and other methods
    // Constructor example shown below
    public Billet() {
    }

    public Billet(String typeBillet, double prix, Integer iDAttraction) {
        this.typeBillet = typeBillet;
        this.prix = prix;
        this.dateEmission = new Date();
        this.etat = "non utilisé";
        this.iDAttraction = iDAttraction;
    }

    // Getters and setters
    public Integer getIDBillet() {
        return iDBillet;
    }

    public void setIDBillet(Integer iDBillet) {
        this.iDBillet = iDBillet;
    }

    public String getTypeBillet() {
        return typeBillet;
    }

    public void setTypeBillet(String typeBillet) {
        this.typeBillet = typeBillet;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Integer getIDClient() {
        return iDClient;
    }

    public void setIDClient(Integer iDClient) {
        this.iDClient = iDClient;
    }

    public Integer getIDAttraction() {
        return iDAttraction;
    }

    public void setIDAttraction(Integer iDAttraction) {
        this.iDAttraction = iDAttraction;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.iDBillet);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Billet other = (Billet) obj;
        return Objects.equals(this.iDBillet, other.iDBillet);
    }

    @Override
    public String toString() {
        return "Billet{" + "iDBillet=" + iDBillet + ", typeBillet=" + typeBillet + ", prix=" + prix + ", dateEmission=" + dateEmission + ", etat=" + etat + '}';
    }
}
