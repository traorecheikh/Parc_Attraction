package models;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Attraction;
import models.Employe;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-17T12:13:52", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Horaire.class)
public class Horaire_ { 

    public static volatile SingularAttribute<Horaire, Attraction> iDAttraction;
    public static volatile SingularAttribute<Horaire, Employe> iDEmploye;
    public static volatile SingularAttribute<Horaire, Date> dateDebut;
    public static volatile SingularAttribute<Horaire, Integer> iDHoraire;
    public static volatile SingularAttribute<Horaire, Date> dateFin;

}