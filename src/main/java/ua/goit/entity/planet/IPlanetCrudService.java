package ua.goit.entity.planet;

import org.hibernate.Session;

import java.util.List;

public interface IPlanetCrudService {

    void createPlanet(Planet planet);

    Planet readPlanet(String planetId);

    List<Planet> readAllPlanets();

    void updatePlanet(Planet planet);

    void deletePlanet(Planet planet);

    void deletePlanetById(String id);
}

