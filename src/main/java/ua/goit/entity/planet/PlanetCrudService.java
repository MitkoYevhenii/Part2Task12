package ua.goit.entity.planet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.storage.hibernate.HibernateUtil;

import java.util.List;

public class PlanetCrudService implements IPlanetCrudService {

    @Override
    public void createPlanet(Planet planet) {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            session.beginTransaction();
            session.persist(planet);
            session.getTransaction().commit();
        }
    }

    @Override
    public Planet readPlanet(String planetId) {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            return session.get(Planet.class, planetId);
        }
    }

    @Override
    public List<Planet> readAllPlanets() {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            return session.createQuery("from Planet", Planet.class).list();
        }
    }

    @Override
    public void updatePlanet(Planet planet) {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(planet);
            transaction.commit();
        }
    }

    @Override
    public void deletePlanet(Planet planet) {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            session.beginTransaction();
            session.remove(planet);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deletePlanetById(String id) {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                session.remove(planet);
                session.getTransaction().commit();
            } else {
                System.out.println("Planet with id " + id + " not found.");
                session.getTransaction().rollback();
            }
        }
    }
}
