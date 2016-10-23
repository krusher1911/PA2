package dao;

import org.hibernate.Session;
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

    protected static Session getSession() {
        Configuration c = new Configuration().addResource("hibernate.cfg.xml").configure();
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(c.getProperties());
        SessionFactory sf = c.buildSessionFactory(ssrb.build());
        Session sessao = sf.openSession();
        return sessao;
    }

    protected static void closeSession(Session sessao) {
        sessao.close();
    }

}
