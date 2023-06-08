package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

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

        // creating products collection
        Product product1 = new Product("Szafa", 5);
        Product product2 = new Product("Ławka", 30);
        Product product3 = new Product("Komoda", 2);
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        try {
            Transaction tx = session.beginTransaction();

            // finding latest supplier
            Supplier supplier = session.get(Supplier.class, 1);
            supplier.addProducts(productList);
            session.save(product1);
            session.save(product2);
            session.save(product3);
            tx.commit();
        } finally {
            session.close();
        }
    }
}