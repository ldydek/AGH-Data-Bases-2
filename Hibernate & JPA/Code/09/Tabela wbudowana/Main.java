package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    private static final EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void main(final String[] args) throws Exception {
        final EntityManager entityManager = getEntityManager();

        Supplier supplier = new Supplier("Raben", new Address("Kraków", "Czarnowiejska"));
        try {
            EntityTransaction tx = entityManager.getTransaction();
            entityManager.persist(supplier);
            tx.begin();
            tx.commit();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
