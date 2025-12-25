package com.example.client_service.repositories;

import com.example.client_service.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository pour les clients
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
