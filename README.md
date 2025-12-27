# Microservices Eureka Architecture

Architecture microservices avec découverte de services.

## Services

- Eureka Server (port 8761)
- Gateway (port 8888)
- Service Client (port 8088)
- Service Voiture (port 8082)

## Démarrage

```bash
# Dans chaque répertoire de service
mvn spring-boot:run
```

## Ordre de démarrage

1. eureka-server
2. service-gateway
3. service-client
4. service-voiture
# tp-20


## Author

- **Karkachi Mohamed**
