package com.raphaelgosteli.project.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersistenceService {

    private static PersistenceService persistenceService;
    private static Session session;

    private PersistenceService() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public static Session get() {
        if (persistenceService == null) {
            persistenceService = new PersistenceService();
        }
        return session;
    }
}