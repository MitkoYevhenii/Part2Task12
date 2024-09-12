package ua.goit.storage.hibernate;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ua.goit.entity.client.Client;
import ua.goit.entity.client.ClientCrudService;
import ua.goit.entity.planet.PlanetCrudService;

public class HibernateUtil {
    private static final HibernateUtil INSTANCE;

    @Getter
    private final SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration
                .addAnnotatedClass(Client.class)
                .buildSessionFactory(
                        new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build()
        );
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }

    public Session startSession() {
        return getSessionFactory().openSession();
    }

    public static void main(String[] args) {
        HibernateUtil util = HibernateUtil.getInstance();

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();



        try(Session session = util.getSessionFactory().openSession()) {
            Client client = new Client();
            client.setName("Yevhenii Mitko");
            clientCrudService.createClient(client);

        }
    }
}
