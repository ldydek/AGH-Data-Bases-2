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

        Product smartphone = new Product("Smartfon", 10);
        Product television = new Product("Telewizor", 5);
        Product tablet = new Product("Tablet", 20);
        Invoice invoice1 = new Invoice();
        Invoice invoice2 = new Invoice();
        try {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            invoice1.addProduct(smartphone, 2);
            invoice1.addProduct(television, 1);
            invoice2.addProduct(tablet, 4);
            entityManager.persist(invoice1);
            entityManager.persist(invoice2);
            tx.commit();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
