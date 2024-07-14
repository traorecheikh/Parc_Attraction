package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "utilisateur")
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findByIDUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.iDUtilisateur = :iDUtilisateur"),
    @NamedQuery(name = "Utilisateur.findByNomUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.nomUtilisateur = :nomUtilisateur"),
    @NamedQuery(name = "Utilisateur.findByMotdepasse", query = "SELECT u FROM Utilisateur u WHERE u.motdepasse = :motdepasse"),
    @NamedQuery(name = "Utilisateur.findByEmail", query = "SELECT u FROM Utilisateur u WHERE u.email = :email"),
    @NamedQuery(name = "Utilisateur.findByDateInscription", query = "SELECT u FROM Utilisateur u WHERE u.dateInscription = :dateInscription"),
    @NamedQuery(name = "Utilisateur.findByDerniereConnexion", query = "SELECT u FROM Utilisateur u WHERE u.derniereConnexion = :derniereConnexion"),
    @NamedQuery(name = "Utilisateur.findByEstAdmin", query = "SELECT u FROM Utilisateur u WHERE u.estAdmin = :estAdmin")
})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ID_Utilisateur")
    private Integer iDUtilisateur;

    @Basic(optional = false)
    @Column(name = "Nom_Utilisateur")
    private String nomUtilisateur;

    @Basic(optional = false)
    @Column(name = "Mot_de_passe")
    private String motdepasse;

    @Basic(optional = false)
    @Column(name = "Email")
    private String email;

    @Column(name = "Date_Inscription")
    @Temporal(TemporalType.DATE)
    private Date dateInscription;

    @Column(name = "Derniere_Connexion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date derniereConnexion;

    @Column(name = "Est_Admin")
    private Boolean estAdmin;

    // Default constructor
    public Utilisateur() {
    }

    // Constructor with parameters
    public Utilisateur( String nomUtilisateur, String motdepasse, String email) {
        this.nomUtilisateur = nomUtilisateur;
        this.motdepasse = motdepasse;
        this.email = email;
        this.dateInscription = new Date(); // Set current date as default
        this.derniereConnexion = null; // Default to null
        this.estAdmin = false; // Default to false
    }

    // Getters and setters

    public Integer getIDUtilisateur() {
        return iDUtilisateur;
    }

    public void setIDUtilisateur(Integer iDUtilisateur) {
        this.iDUtilisateur = iDUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Date getDerniereConnexion() {
        return derniereConnexion;
    }

    public void setDerniereConnexion(Date derniereConnexion) {
        this.derniereConnexion = derniereConnexion;
    }

    public Boolean getEstAdmin() {
        return estAdmin;
    }

    public void setEstAdmin(Boolean estAdmin) {
        this.estAdmin = estAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDUtilisateur != null ? iDUtilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        return (this.iDUtilisateur != null || other.iDUtilisateur == null) && (this.iDUtilisateur == null || this.iDUtilisateur.equals(other.iDUtilisateur));
    }

    @Override
    public String toString() {
        return "models.Utilisateur[ iDUtilisateur=" + iDUtilisateur + " ]";
    }
}
