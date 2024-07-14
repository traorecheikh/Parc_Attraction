/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @NamedQuery(name = "Billet.findAll", query = "SELECT b FROM Billet b"),
    @NamedQuery(name = "Billet.findByIDBillet", query = "SELECT b FROM Billet b WHERE b.iDBillet = :iDBillet"),
    @NamedQuery(name = "Billet.findByTypeBillet", query = "SELECT b FROM Billet b WHERE b.typeBillet = :typeBillet"),
    @NamedQuery(name = "Billet.findByPrix", query = "SELECT b FROM Billet b WHERE b.prix = :prix"),
    @NamedQuery(name = "Billet.findByDateEmission", query = "SELECT b FROM Billet b WHERE b.dateEmission = :dateEmission"),
    @NamedQuery(name = "Billet.findByDateUtilisation", query = "SELECT b FROM Billet b WHERE b.dateUtilisation = :dateUtilisation"),
    @NamedQuery(name = "Billet.findByEtat", query = "SELECT b FROM Billet b WHERE b.etat = :etat"),
    @NamedQuery(name = "Billet.findByDateReservation", query = "SELECT b FROM Billet b WHERE b.dateReservation = :dateReservation"),
    @NamedQuery(name = "Billet.findByHeureReservation", query = "SELECT b FROM Billet b WHERE b.heureReservation = :heureReservation")})
public class Billet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_Billet")
    private Integer iDBillet;
    @Column(name = "Type_Billet")
    private String typeBillet;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Prix")
    private double prix;
    @Column(name = "Date_Emission")
    @Temporal(TemporalType.DATE)
    private Date dateEmission;
    @Column(name = "Date_Utilisation")
    @Temporal(TemporalType.DATE)
    private Date dateUtilisation;
    @Column(name = "Etat")
    private String etat;
    @Column(name = "Date_Reservation")
    @Temporal(TemporalType.DATE)
    private Date dateReservation;
    @Column(name = "Heure_Reservation")
    @Temporal(TemporalType.TIME)
    private Date heureReservation;
    @JoinColumn(name = "ID_Client", referencedColumnName = "ID_Client")
    @ManyToOne(fetch = FetchType.LAZY)
    private Client iDClient;
    @JoinColumn(name = "ID_Attraction", referencedColumnName = "ID_Attraction")
    @ManyToOne(fetch = FetchType.LAZY)
    private Attraction iDAttraction;

    public Billet() {
    }

    public Billet(String Type, double prix) {
        this.typeBillet = Type;
        this.prix = prix;
        this.dateUtilisation = null;
        this.etat = "non utilisé";
        this.heureReservation = null;
        this.dateEmission = new Date();
        this.iDAttraction = null;
        this.iDClient = null;
        this.dateReservation = null;
        
        
        
    }

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

    public Date getDateUtilisation() {
        return dateUtilisation;
    }

    public void setDateUtilisation(Date dateUtilisation) {
        this.dateUtilisation = dateUtilisation;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Date getHeureReservation() {
        return heureReservation;
    }

    public void setHeureReservation(Date heureReservation) {
        this.heureReservation = heureReservation;
    }

    public Client getIDClient() {
        return iDClient;
    }

    public void setIDClient(Client iDClient) {
        this.iDClient = iDClient;
    }

    public Attraction getIDAttraction() {
        return iDAttraction;
    }

    public void setIDAttraction(Attraction iDAttraction) {
        this.iDAttraction = iDAttraction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDBillet != null ? iDBillet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Billet)) {
            return false;
        }
        Billet other = (Billet) object;
        if ((this.iDBillet == null && other.iDBillet != null) || (this.iDBillet != null && !this.iDBillet.equals(other.iDBillet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Billet[ iDBillet=" + iDBillet + " ]";
    }
    
}
