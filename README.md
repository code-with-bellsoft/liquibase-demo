# Liquibase Demo App

A Spring Boot application demonstrating the use of Liquibase for common database migration flows:

- Create and manage changelogs and changesets
- Update DB schema and data
- Use preconditions
- Use rollbacks
- Automate changelog generation
- Perform SQL validation before applying changesets
- Integrate Liquibase into GitHub Action workflows to validate changes and perform db migration before deploying the app.


## Prerequisites

- Java 24
- Docker and Docker Compose

## Running the Application

### Running Locally

1. Start the PostgreSQL container:
   ```bash
   docker-compose up -d postgres
   ```

2. Build and run the app:
   ```bash
   ./mvnw spring-boot:run
   ```