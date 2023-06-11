package org.example;

import javax.persistence.*;

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

        try {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            Supplier supplier1 = new Supplier("DPD", "Atomowa", "Kraków",
                    "01-123", "49102028922276300500000000");
            Supplier supplier2 = new Supplier("UPS", "Jerozolimska", "Poznań",
                    "01-124", "49102028922276300500000001");
            Customer customer1 = new Customer("U Kowalczyka", "Wiśniowa", "Chojnice", "02-234", 50);
            Customer customer2 = new Customer("U Janiny", "Lawendowa", "Słupsk", "01-154", 10);
            entityManager.persist(supplier1);
            entityManager.persist(supplier2);
            entityManager.persist(customer1);
            entityManager.persist(customer2);
            tx.commit();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
