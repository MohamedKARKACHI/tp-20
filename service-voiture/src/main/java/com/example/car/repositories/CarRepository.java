package com.example.car.repositories;

import com.example.car.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository pour les voitures
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
