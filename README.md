# Spring Boot PostgreSQL Docker Example

This project demonstrates a Spring Boot application with PostgreSQL database running in Docker containers. It includes
user profile management with REST APIs and uses modern development practices.

## Technologies Used

- Java 21
- Spring Boot 3.5.0
- PostgreSQL 17.5
- Docker & Docker Compose
- Maven 3.9.9
- Spring Data JPA
- Lombok
- Testcontainers (for integration testing)

## Prerequisites

- Java 21 or higher
- Docker and Docker Compose
- Maven (or use included mvnw wrapper)

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/hendisantika/spring-postgres-docker.git
   cd spring-postgres-docker
   ```

2. Start the application with Docker Compose:
   ```bash
   mvn clean spring-boot:run
   ```

3. The application will be available at: `http://localhost:8080`
4. PgAdmin will be available at: `http://localhost:5050`

## API Endpoints

### User Profiles

- **Create User Profile**
    - POST `/api/user-profiles`
    - Request body: UserProfile object

- **Get All User Profiles**
    - GET `/api/user-profiles`

- **Get User Profile by ID**
    - GET `/api/user-profiles/{id}`

- **Update User Profile**
    - PUT `/api/user-profiles/{id}`
    - Request body: UserProfile object

- **Delete User Profile**
    - DELETE `/api/user-profiles/{id}`

## Database Configuration

The PostgreSQL database is configured with the following default settings:

- Host: localhost
- Port: 5432
- Database: demo
- Username: yu71
- Password: 53cret or (stored in db/password.txt)

## Running Tests

The project includes integration tests using Testcontainers:

```bash
./mvnw clean test
```

## Features

- RESTful API endpoints for CRUD operations
- PostgreSQL database integration
- Docker containerization
- Integration testing with Testcontainers
- Proper error handling
- UUID-based entity IDs
- Audit fields (createBy, updateBy)
- PgAdmin integration for database management

## Project Structure

```
├── src/
│   ├── main/
│   │   ├── java/         # Java source files
│   │   └── resources/    # Application properties and SQL scripts
│   └── test/
│       └── java/         # Test files
├── compose.yml           # Docker Compose configuration
├── Dockerfile            # Docker configuration
└── pom.xml              # Maven configuration
```

## Contributing

Feel free to open issues and pull requests!
