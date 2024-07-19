package models;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Client;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-18T10:41:00", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Billet.class)
public class Billet_ { 

    public static volatile SingularAttribute<Billet, String> typeBillet;
    public static volatile SingularAttribute<Billet, Integer> prix;
    public static volatile SingularAttribute<Billet, Date> dateEmission;
    public static volatile SingularAttribute<Billet, Integer> iDBillet;
    public static volatile SingularAttribute<Billet, String> etat;
    public static volatile SingularAttribute<Billet, Date> dateReservation;
    public static volatile SingularAttribute<Billet, Client> iDClient;
    public static volatile SingularAttribute<Billet, Date> dateUtilisation;
    public static volatile SingularAttribute<Billet, Date> heureReservation;

}