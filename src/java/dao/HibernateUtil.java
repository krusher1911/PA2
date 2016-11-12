package dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Bruna
 */
class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration c = new Configuration().configure();
            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(c.getProperties());
            sessionFactory = c.buildSessionFactory(ssrb.build());
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    protected static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    protected static void closeSessionFactory(SessionFactory sf) {
        sf.close();
    }

}
