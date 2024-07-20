/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Cheikh
 */
@Entity
@Table(name = "employe")
@NamedQueries({
    @NamedQuery(name = "Employe.findAll", query = "SELECT e FROM Employe e"),
    @NamedQuery(name = "Employe.findByIDEmploye", query = "SELECT e FROM Employe e WHERE e.iDEmploye = :iDEmploye"),
    @NamedQuery(name = "Employe.findByNom", query = "SELECT e FROM Employe e WHERE e.nom = :nom"),
    @NamedQuery(name = "Employe.findByPrenom", query = "SELECT e FROM Employe e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Employe.findByPoste", query = "SELECT e FROM Employe e WHERE e.poste = :poste"),
    @NamedQuery(name = "Employe.findByDateEmbauche", query = "SELECT e FROM Employe e WHERE e.dateEmbauche = :dateEmbauche"),
    @NamedQuery(name = "Employe.findBySalaire", query = "SELECT e FROM Employe e WHERE e.salaire = :salaire"),
    @NamedQuery(name = "Employe.findByCarteEmploye", query = "SELECT e FROM Employe e WHERE e.carteEmploye = :carteEmploye")})
public class Employe implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Salaire")
    private int salaire;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Employe")
    private Integer iDEmploye;
    @Basic(optional = false)
    @Column(name = "Nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "Prenom")
    private String prenom;
    @Column(name = "Poste")
    private String poste;
    @Column(name = "Date_Embauche")
    @Temporal(TemporalType.DATE)
    private Date dateEmbauche;
    @Lob
    @Column(name = "Disponibilite")
    private String disponibilite;
    @Column(name = "Carte_Employe")
    private String carteEmploye;
    @OneToMany(mappedBy = "iDEmploye")
    private List<Horaire> horaireList;

    public Employe() {
    }

    public Employe(Integer iDEmploye) {
        this.iDEmploye = iDEmploye;
    }

    public Employe(String nom, String prenom, String poste, int salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.salaire = salaire;
        this.dateEmbauche = new Date();
        this.disponibilite = "non disponible";
        
    }

    public Integer getIDEmploye() {
        return iDEmploye;
    }

    public void setIDEmploye(Integer iDEmploye) {
        this.iDEmploye = iDEmploye;
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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }


    public String getDisponibilite() {
        return disponibilite;
    }
    public boolean isDisponible() {
        return "disponible".equalsIgnoreCase(disponibilite);
    }


    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }

    public String getCarteEmploye() {
        return carteEmploye;
    }

    public void setCarteEmploye(String carteEmploye) {
        this.carteEmploye = carteEmploye;
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
        hash += (iDEmploye != null ? iDEmploye.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employe)) {
            return false;
        }
        Employe other = (Employe) object;
        if ((this.iDEmploye == null && other.iDEmploye != null) || (this.iDEmploye != null && !this.iDEmploye.equals(other.iDEmploye))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Employe[ iDEmploye=" + iDEmploye + " ]";
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }
    
}
