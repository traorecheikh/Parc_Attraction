package models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Billet;
import models.Horaire;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-20T17:33:24", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Attraction.class)
public class Attraction_ { 

    public static volatile SingularAttribute<Attraction, Integer> iDAttraction;
    public static volatile SingularAttribute<Attraction, Integer> dureeminutes;
    public static volatile ListAttribute<Attraction, Horaire> horaireList;
    public static volatile SingularAttribute<Attraction, Integer> capacite;
    public static volatile SingularAttribute<Attraction, String> description;
    public static volatile ListAttribute<Attraction, Billet> billetList;
    public static volatile SingularAttribute<Attraction, String> nom;
    public static volatile SingularAttribute<Attraction, String> horairesFonctionnement;
    public static volatile SingularAttribute<Attraction, String> etat;

}