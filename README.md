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

Local MySQL credentials (already configured in `application.properties`):

- Username: `consultant`
- Password: `consultant123`
- Database: `consultant_management`

To recreate the schema and sample data:

```bash
mysql -u root -pconsultant123 < database.sql
```

## Run

```bash
./mvnw spring-boot:run
```

Then open http://localhost:8080
