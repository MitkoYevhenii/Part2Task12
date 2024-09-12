package ua.goit.entity.client;

import java.util.List;

public interface IClientCrudService {
    void createClient(Client client);

    Client readClient(Long clientId);

    List<Client> readAllClients();

    public void updateClient(Client client);

    void deleteClient(Client client);

    void deleteClientById(long id);
}
