# SubsHub — Subscription Management Store

A Spring Boot web application for managing subscriptions and categories, secured with Keycloak (OAuth2/OIDC) and backed by PostgreSQL with Redis caching.

## Features

- Keycloak-based SSO login (OAuth2 Authorization Code + OIDC)
- Category browsing with Redis-cached queries
- User registration and profile management via Keycloak Admin Client
- Thymeleaf server-side rendered UI

## Tech Stack

| Layer | Technology |
|---|---|
| Framework | Spring Boot 3.5.5 (Java 24) |
| Security | Spring Security, Keycloak 26, OAuth2/OIDC |
| Database | PostgreSQL |
| Cache | Redis |
| UI | Thymeleaf |
| Build | Maven |

## Prerequisites

- Java 24+
- Maven 3.9+
- PostgreSQL running on `localhost:5432`
- Redis running on `localhost:6379`
- Keycloak running on `localhost:9090` with a realm named `subsHub`

## Installation

### 1. Clone the repository

```bash
git clone <repository-url>
cd store
```

### 2. Configure Keycloak

1. Start Keycloak on port `9090`.
2. Create a realm named `subsHub`.
3. Create a client named `subsHub` with:
   - Client authentication enabled
   - Authorization Code grant type
   - Valid redirect URI: `http://localhost:8080/*`
4. Copy the client secret into `application.properties`.

### 3. Configure the database

Create a PostgreSQL database and user:

```sql
CREATE USER myuser WITH PASSWORD 'mypassword';
CREATE DATABASE "subsHub" OWNER myuser;
```

### 4. Configure application properties

Edit [`src/main/resources/application.properties`](src/main/resources/application.properties) and update the following values to match your environment:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/subsHub
spring.datasource.username=myuser
spring.datasource.password=mypassword

spring.security.oauth2.client.registration.keycloak.client-secret=<your-client-secret>
spring.security.oauth2.client.provider.keycloak.issuer-uri=http://localhost:9090/realms/subsHub

spring.data.redis.host=localhost
spring.data.redis.port=6379
```

### 5. Build and run

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## Usage

| URL | Description |
|---|---|
| `http://localhost:8080/` | Public landing page |
| `http://localhost:8080/home` | Authenticated home page (requires login) |
| `http://localhost:8080/logout` | Logout (redirects to Keycloak) |

Navigating to `/home` will redirect unauthenticated users to the Keycloak login page. After a successful login the user is returned to the home page.

## Running Tests

```bash
mvn test
```

## License

This project is for educational and demonstration purposes. No license is currently specified — all rights reserved by the author.
