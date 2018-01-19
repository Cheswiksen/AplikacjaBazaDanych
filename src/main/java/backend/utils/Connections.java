package backend.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class Connections {
    private static final SessionFactory sf;

    static {
        try {
            sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (HibernateException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    static Session getSession() {
        Session session=null;
        try {
            session=sf.openSession();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return session;
    }
}
