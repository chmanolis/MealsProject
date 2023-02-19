package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AppDatabase {

    private static final String COVID_DB = "mealsDB";

    public static EntityManager getAppEntityManager() {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(COVID_DB);
        return emf.createEntityManager();
    }
}