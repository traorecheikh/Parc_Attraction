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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Cheikh
 */
@Entity
@Table(name = "attraction")
@NamedQueries({
    @NamedQuery(name = "Attraction.findAll", query = "SELECT a FROM Attraction a"),
    @NamedQuery(name = "Attraction.findByIDAttraction", query = "SELECT a FROM Attraction a WHERE a.iDAttraction = :iDAttraction"),
    @NamedQuery(name = "Attraction.findByNom", query = "SELECT a FROM Attraction a WHERE a.nom = :nom"),
    @NamedQuery(name = "Attraction.findByCapacite", query = "SELECT a FROM Attraction a WHERE a.capacite = :capacite"),
    @NamedQuery(name = "Attraction.findByDureeminutes", query = "SELECT a FROM Attraction a WHERE a.dureeminutes = :dureeminutes"),
    @NamedQuery(name = "Attraction.findByHorairesFonctionnement", query = "SELECT a FROM Attraction a WHERE a.horairesFonctionnement = :horairesFonctionnement"),
    @NamedQuery(name = "Attraction.findByEtat", query = "SELECT a FROM Attraction a WHERE a.etat = :etat")})
public class Attraction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Attraction")
    private Integer iDAttraction;
    @Basic(optional = false)
    @Column(name = "Nom")
    private String nom;
    @Lob
    @Column(name = "Description")
    private String description;
    @Column(name = "Capacite")
    private Integer capacite;
    @Column(name = "Duree_minutes")
    private Integer dureeminutes;
    @Column(name = "Horaires_Fonctionnement")
    private String horairesFonctionnement;
    @Column(name = "Etat")
    private String etat;
    @OneToMany(mappedBy = "iDAttraction")
    private List<Horaire> horaireList;

    public Attraction() {
    }

    public Attraction(String nom, String description, int capacite, int duree,String horaire) {
        this.capacite = capacite;
        this.nom = nom;
        this.description = description;
        this.dureeminutes = duree;
        this.horairesFonctionnement = horaire;
        this.etat = "hors service";
    }

    public Attraction(Integer iDAttraction, String nom) {
        this.iDAttraction = iDAttraction;
        this.nom = nom;
    }

    public Integer getIDAttraction() {
        return iDAttraction;
    }

    public void setIDAttraction(Integer iDAttraction) {
        this.iDAttraction = iDAttraction;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public Integer getDureeminutes() {
        return dureeminutes;
    }

    public void setDureeminutes(Integer dureeminutes) {
        this.dureeminutes = dureeminutes;
    }

    public String getHorairesFonctionnement() {
        return horairesFonctionnement;
    }

    public void setHorairesFonctionnement(String horairesFonctionnement) {
        this.horairesFonctionnement = horairesFonctionnement;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public List<Horaire> getHoraireList() {
        return horaireList;
    }

    public void setHoraireList(List<Horaire> horaireList) {
        this.horaireList = horaireList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDAttraction != null ? iDAttraction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attraction)) {
            return false;
        }
        Attraction other = (Attraction) object;
        if ((this.iDAttraction == null && other.iDAttraction != null) || (this.iDAttraction != null && !this.iDAttraction.equals(other.iDAttraction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Attraction[ iDAttraction=" + iDAttraction + " ]";
    }
    
}
