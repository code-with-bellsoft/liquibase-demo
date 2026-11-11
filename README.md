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

- Java 25 (the project uses Spring Boot 4.1.2 and Liquibase 5.0.4)
- Docker and Docker Compose

## Running the Application

### Running Locally

The database credentials are read from environment variables:

```bash
export DB_USERNAME=neurowatch_user
export DB_PASSWORD=<choose-a-local-password>
```

Build and run the app:

```bash
./mvnw spring-boot:run
```

Spring Boot's Docker Compose support starts the PostgreSQL container from `compose.yml` automatically, and Liquibase applies the changelogs on startup. To start the database yourself (e.g., for the Maven plugin goals below), run `docker compose up -d`.

> If you have a database volume from an older version of this project, recreate it with `docker compose down -v`: PostgreSQL 18 stores its data in `/var/lib/postgresql` and can't reuse data from an older major version.

### Liquibase Maven Plugin

The plugin uses the same `DB_USERNAME` and `DB_PASSWORD` variables. It resolves the included changelogs from the compiled resources, so build the project first:

```bash
./mvnw compile liquibase:rollback -Dliquibase.rollbackCount=1
./mvnw clean compile liquibase:diff
```

### Tests

`./mvnw test` starts its own PostgreSQL container with Testcontainers and verifies that all changesets are applied.

### GitHub Actions

The workflow in `.github/workflows/db-migration.yaml` expects a `DB_PASSWORD` repository secret (Settings → Secrets and variables → Actions).