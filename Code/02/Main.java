package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

        // creating new supplier
        Supplier supplier = new Supplier("DPD", "Atomowa", "Kraków");
        try {
            Transaction tx = session.beginTransaction();

            // finding latest product
            Product product = session.get(Product.class, 1);
            product.setSupplier(supplier);
            session.save(supplier);
            tx.commit();
        } finally {
            session.close();
        }
    }
}