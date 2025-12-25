package com.example.car.services;

import com.example.car.entities.Car;
import com.example.car.models.CarResponse;
import com.example.car.models.Client;
import com.example.car.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service de gestion des voitures
 */
@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private RestTemplate restTemplate;
    private static final String CLIENT_SERVICE_URL = "http://localhost:8888/SERVICE-CLIENT/api/client/";

    public List<CarResponse> findAll() {
        return carRepository.findAll().stream().map(this::mapToCarResponse).collect(Collectors.toList());
    }

    public CarResponse findById(Long id) throws Exception {
        Car car = carRepository.findById(id).orElseThrow(() -> new Exception("Non trouvé"));
        return mapToCarResponse(car);
    }

    private CarResponse mapToCarResponse(Car car) {
        Client client = null;
        try {
            client = restTemplate.getForObject(CLIENT_SERVICE_URL + car.getClient_id(), Client.class);
        } catch (Exception e) {
            System.err.println("Erreur: " + e.getMessage());
        }
        return CarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .matricule(car.getMatricule())
                .client(client)
                .build();
    }
}
