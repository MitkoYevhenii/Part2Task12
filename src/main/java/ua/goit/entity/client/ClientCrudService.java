package ua.goit.entity.client;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.goit.storage.hibernate.HibernateUtil;

import java.util.List;

public class ClientCrudService implements IClientCrudService {

    @Override
    public void createClient(Client client) {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            session.beginTransaction();
            session.persist(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public Client readClient(Long clientId) {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            return session.get(Client.class, clientId);
        }
    }

    @Override
    public List<Client> readAllClients() {
        try (Session session = HibernateUtil.getInstance().startSession()) {
            return session.createQuery("from Client", Client.class).getResultList();
        }
    }

    @Override
    public void updateClient(Client client) {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            session.update(client);
        }
    }

    @Override
    public void deleteClient(Client client) {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            session.beginTransaction();
            session.remove(client);
            session.getTransaction().commit();

        }
    }

    @Override
    public void deleteClientById(long id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            if (client != null) {
                session.remove(client);
                session.getTransaction().commit();
            } else {
                System.out.println("Client with id " + id + " not found.");
                session.getTransaction().rollback();
            }
        }
    }
}

