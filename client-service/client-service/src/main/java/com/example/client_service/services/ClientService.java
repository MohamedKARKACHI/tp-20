package com.example.client_service.services;

import com.example.client_service.entities.Client;
import com.example.client_service.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service de gestion des clients
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) throws Exception {
        return clientRepository.findById(id).orElseThrow(() -> new Exception("Non trouvé"));
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }
}
