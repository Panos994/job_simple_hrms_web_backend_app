# job_simple_hrms_web_backend_app

A simple HRMS (Human Resources Management System) backend built with **Spring Boot**.

## Tech Stack
- Java + Spring Boot
- Spring Web (REST APIs)
- Spring Data JPA / Hibernate
- Spring Security
  - JWT-based authentication/authorization
  - Role-based access control (RBAC)
- Validation (Jakarta Validation)
- Database: PostgreSQL or MySQL (configurable)

## Core Features (high-level)
- User authentication (Register / Login) with **JWT**
- Role & permission handling (e.g., ADMIN / HR / USER)
- Employee management (CRUD)
- Job positions / departments (CRUD)
- Basic HR flows (extendable)

## Getting Started
### Prerequisites
- Java 17+ (or the version defined in the project)
- Maven
- A running database (PostgreSQL/MySQL)

### Run
```bash
mvn spring-boot:run
```

## Configuration
Set your environment in `application.properties` / `application.yml`:
- datasource URL/username/password
- JWT secret + expiration
- server port

## API
The application exposes REST endpoints (e.g. `/api/...`).
Use a tool like Postman to:
1. Register/Login
2. Copy the returned JWT
3. Send it as:
   - `Authorization: Bearer <token>`

## Notes
This is a learning / demo project and can be extended with:
- refresh tokens
- audit logging
- advanced HR workflows
- Swagger/OpenAPI documentation
