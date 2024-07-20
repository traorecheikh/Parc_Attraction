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
    @NamedQuery(name = "Billet.findAll", query = "SELECT b FROM Billet b"),
    @NamedQuery(name = "Billet.findByIDBillet", query = "SELECT b FROM Billet b WHERE b.iDBillet = :iDBillet"),
    @NamedQuery(name = "Billet.findByTypeBillet", query = "SELECT b FROM Billet b WHERE b.typeBillet = :typeBillet"),
    @NamedQuery(name = "Billet.findByPrix", query = "SELECT b FROM Billet b WHERE b.prix = :prix"),
    @NamedQuery(name = "Billet.findByDateUtilisation", query = "SELECT b FROM Billet b WHERE b.dateUtilisation = :dateUtilisation"),
    @NamedQuery(name = "Billet.findByEtat", query = "SELECT b FROM Billet b WHERE b.etat = :etat")})
public class Billet implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Prix")
    private int prix;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Billet")
    private Integer iDBillet;
    @Column(name = "Type_Billet")
    private String typeBillet;
    @Column(name = "Date_Utilisation")
    @Temporal(TemporalType.DATE)
    private Date dateUtilisation;
    @Column(name = "Etat")
    private String etat;
    @JoinColumn(name = "ID_Client", referencedColumnName = "ID_Client")
    @ManyToOne
    private Client iDClient;

    public Billet() {
    }

    public Billet(String Type, int prix) {
        this.dateUtilisation = new Date();
        this.etat = "utilisé";
        this.prix = prix;
        this.typeBillet = Type;
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

    public Client getIDClient() {
        return iDClient;
    }

    public void setIDClient(Client iDClient) {
        this.iDClient = iDClient;
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

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
}
