# Spring Boot PostgreSQL Docker Example

[![Java CI with Maven](https://github.com/hendisantika/spring-postgres-docker/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-postgres-docker/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-6DB33F?logo=springboot)

This project demonstrates a Spring Boot application with PostgreSQL database running in Docker containers. It includes
user profile management with REST APIs and uses modern development practices.

## Technologies Used

- Java 25 (LTS)
- Spring Boot 4.1.1
- PostgreSQL 17.5
- Docker & Docker Compose
- Maven 3.9.12 (via the included `mvnw` wrapper)
- Spring Data JPA & Spring Data JDBC
- Lombok
- Testcontainers 2.x (for integration testing)

## Prerequisites

- Java 25 or higher (e.g. [Eclipse Temurin 25](https://adoptium.net/))
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
   ./mvnw clean spring-boot:run
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

## Curl Examples

### Create a User Profile

```bash
curl -X POST http://localhost:8080/api/user-profiles \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "birthDate": "1990-01-01",
    "sex": 1
  }'
```

### Get All User Profiles

```bash
curl -X GET http://localhost:8080/api/user-profiles
```

### Get User Profile by ID

```bash
curl -X GET http://localhost:8080/api/user-profiles/123e4567-e89b-12d3-a456-426614174000
```

Note: Replace the UUID with an actual user profile ID.

### Update User Profile

```bash
curl -X PUT http://localhost:8080/api/user-profiles/123e4567-e89b-12d3-a456-426614174000 \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Smith",
    "email": "john.smith@example.com",
    "birthDate": "1990-01-01",
    "sex": 1
  }'
```

Note: Replace the UUID with an actual user profile ID.

### Delete User Profile

```bash
curl -X DELETE http://localhost:8080/api/user-profiles/123e4567-e89b-12d3-a456-426614174000
```

Note: Replace the UUID with an actual user profile ID.

## Database Configuration

The PostgreSQL database is configured with the following default settings:

- Host: localhost
- Port: 5432
- Database: demo
- Username: yu71
- Password: 53cret or (stored in db/password.txt)

## Running Tests

The project includes integration tests using Testcontainers (Docker must be running):

```bash
./mvnw clean verify
```

> **Note (JDK 23+):** annotation processors are no longer discovered implicitly, so Lombok and the
> Spring Boot configuration processor are declared under `annotationProcessorPaths` of the
> `maven-compiler-plugin` in `pom.xml`.

## Building the Docker Image

The multi-stage `Dockerfile` builds with `maven:3.9.12-eclipse-temurin-25` and runs on
`eclipse-temurin:25-jre-alpine`:

```bash
docker build -t spring-postgres-docker .
docker run --rm -p 8080:8080 spring-postgres-docker
```

## Continuous Integration

GitHub Actions ([`.github/workflows/maven.yml`](.github/workflows/maven.yml)) runs `./mvnw -B verify` on
Temurin JDK 25 for every push and pull request to `main` (and on manual dispatch). On pushes to `main` the
Maven dependency graph is submitted to GitHub to improve Dependabot alerts.

## Dependency Updates

[Dependabot](.github/dependabot.yml) keeps dependencies up to date:

| Ecosystem        | Schedule              | Notes                                                                 |
|------------------|-----------------------|-----------------------------------------------------------------------|
| Maven            | Daily 05:00 (WIB)     | Grouped: Spring, Testcontainers, Maven plugins, other minor/patch     |
| GitHub Actions   | Weekly, Monday        | All actions grouped into a single PR                                  |
| Docker           | Weekly, Monday        | Base images in `Dockerfile` (Maven 4 pre-releases ignored)            |
| Docker Compose   | Weekly, Monday        | Images in `compose.yml`                                               |

PRs use conventional commit prefixes (`build(deps)`, `ci(deps)`, `build(docker)`, `build(compose)`) and are
labelled per ecosystem.

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
├── .github/
│   ├── workflows/maven.yml  # CI build on JDK 25
│   └── dependabot.yml       # Dependency update configuration
├── .mvn/                 # Maven wrapper & JVM config
├── compose.yml           # Docker Compose configuration
├── Dockerfile            # Docker configuration
└── pom.xml               # Maven configuration
```

## Contributing

Feel free to open issues and pull requests!
