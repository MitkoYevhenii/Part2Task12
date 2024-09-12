import ua.goit.entity.client.Client;
import ua.goit.entity.client.ClientCrudService;
import ua.goit.entity.planet.PlanetCrudService;
import ua.goit.storage.FlywayService;
import ua.goit.storage.hibernate.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        ClientCrudService clientService = new ClientCrudService();
        PlanetCrudService planetService = new PlanetCrudService();

        FlywayService.initDataBase();

        // Create Clients
        Client client1 = new Client();
        client1.setName("John Doe");
        clientService.createClient(client1);

        Client client2 = new Client();
        client2.setName("Jane Smith");
        clientService.createClient(client2);
    }
}

