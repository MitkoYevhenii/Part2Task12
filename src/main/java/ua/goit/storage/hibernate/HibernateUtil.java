package ua.goit.storage.hibernate;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ua.goit.emtity.client.Client;

public class HibernateUtil {
    private static final HibernateUtil INSTANCE;

    @Getter
    private final SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() {
        sessionFactory = new Configuration().buildSessionFactory(
                new StandardServiceRegistryBuilder().build()
        );
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }

    public static void main(String[] args) {
        HibernateUtil util = HibernateUtil.getInstance();

        Session session = util.getSessionFactory().openSession();
        Client client = session.get(Client.class, 1L);
        System.out.println("client = " + client);
        session.close();
    }
}
