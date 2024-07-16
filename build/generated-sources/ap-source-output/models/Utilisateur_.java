package models;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-16T18:46:56", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ { 

    public static volatile SingularAttribute<Utilisateur, Boolean> estAdmin;
    public static volatile SingularAttribute<Utilisateur, Integer> iDUtilisateur;
    public static volatile SingularAttribute<Utilisateur, Date> dateInscription;
    public static volatile SingularAttribute<Utilisateur, String> nomUtilisateur;
    public static volatile SingularAttribute<Utilisateur, String> motdepasse;
    public static volatile SingularAttribute<Utilisateur, String> email;
    public static volatile SingularAttribute<Utilisateur, Date> derniereConnexion;

}