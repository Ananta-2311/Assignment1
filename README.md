# Consultant Management System

Java Spring Boot web application for managing consultants.

## Stack

- Spring Boot (Web / MVC)
- Spring Data JPA
- MySQL
- Thymeleaf
- Validation
- Bootstrap 5 (CDN)

## Requirements

- Java 21+
- Maven 3.9+
- MySQL running locally

## Configuration

1. Run `database.sql` in MySQL to create the `consultant_management` database and `consultants` table.
2. Replace `YOUR_MYSQL_USERNAME` and `YOUR_MYSQL_PASSWORD` in `src/main/resources/application.properties` with your MySQL credentials.

## Run

```bash
./mvnw spring-boot:run
```

Then open http://localhost:8080
