package com.vinogorova.mailparser;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

public class ManagePriceItemsLoad {
    private static SessionFactory sessionFactory;

    private static SessionFactory getSessionFactory() {
        sessionFactory = new AnnotationConfiguration()
                .configure()
                .addAnnotatedClass(PriceItem.class)
                .buildSessionFactory();

        return sessionFactory;
    }

    public static void addPriceItems(List<PriceItem> list) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        for (PriceItem priceItem : list) {
            session.save(priceItem);
            transaction.commit();
            session.close();
        }
    }

    public static List<PriceItem> getFullPriceList() {

    }
}
