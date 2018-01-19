package backend.Utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connections {
    private static final SessionFactory sf;

    static {
        try {
            sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        Session session=null;
        try {
            session=sf.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }
}
