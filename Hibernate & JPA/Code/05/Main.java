package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();

        try {
            // produkty należące do poszczególnych kategorii
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Category");
            query.getResultList().forEach(c -> {
                System.out.println("Kategoria: " + c + ": ");
                ((Category) c).getProducts().forEach(p -> System.out.println("\t- " + p + ","));
            });

            System.out.println();

            // kategoria, do której należy wybrany produkt
            Product product = session.get(Product.class, 5);
            System.out.println(product.toString() + " należy do kategorii: " + product.getCategory());
            tx.commit();
        } finally {
            session.close();
        }
    }
}