package models;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Horaire;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-17T12:13:52", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Employe.class)
public class Employe_ { 

    public static volatile SingularAttribute<Employe, Integer> iDEmploye;
    public static volatile ListAttribute<Employe, Horaire> horaireList;
    public static volatile SingularAttribute<Employe, Date> dateEmbauche;
    public static volatile SingularAttribute<Employe, String> disponibilite;
    public static volatile SingularAttribute<Employe, String> poste;
    public static volatile SingularAttribute<Employe, Double> salaire;
    public static volatile SingularAttribute<Employe, String> nom;
    public static volatile SingularAttribute<Employe, String> prenom;

}