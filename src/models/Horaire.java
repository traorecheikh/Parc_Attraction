/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
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
@Table(name = "horaire")
@NamedQueries({
    @NamedQuery(name = "Horaire.findAll", query = "SELECT h FROM Horaire h"),
    @NamedQuery(name = "Horaire.findByIDHoraire", query = "SELECT h FROM Horaire h WHERE h.iDHoraire = :iDHoraire"),
    @NamedQuery(name = "Horaire.findByDateDebut", query = "SELECT h FROM Horaire h WHERE h.dateDebut = :dateDebut"),
    @NamedQuery(name = "Horaire.findByDateFin", query = "SELECT h FROM Horaire h WHERE h.dateFin = :dateFin")})
public class Horaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_Horaire")
    private Integer iDHoraire;
    @Column(name = "Date_Debut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "Date_Fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @JoinColumn(name = "ID_Attraction", referencedColumnName = "ID_Attraction")
    @ManyToOne(fetch = FetchType.LAZY)
    private Attraction iDAttraction;
    @ManyToOne
    @JoinColumn(name = "ID_Employe", referencedColumnName = "ID_Employe")
    private Employe iDEmploye;

    public Horaire() {
    }

    public Horaire(Integer iDHoraire) {
        this.iDHoraire = iDHoraire;
    }

    public Integer getIDHoraire() {
        return iDHoraire;
    }

    public void setIDHoraire(Integer iDHoraire) {
        this.iDHoraire = iDHoraire;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Attraction getIDAttraction() {
        return iDAttraction;
    }

    public void setIDAttraction(Attraction iDAttraction) {
        this.iDAttraction = iDAttraction;
    }

    public Employe getIDEmploye() {
        return iDEmploye;
    }

    public void setIDEmploye(Employe iDEmploye) {
        this.iDEmploye = iDEmploye;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDHoraire != null ? iDHoraire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horaire)) {
            return false;
        }
        Horaire other = (Horaire) object;
        if ((this.iDHoraire == null && other.iDHoraire != null) || (this.iDHoraire != null && !this.iDHoraire.equals(other.iDHoraire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "";
    }
    
}
