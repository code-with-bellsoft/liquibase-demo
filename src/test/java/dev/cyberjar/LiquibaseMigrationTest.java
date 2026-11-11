package dev.cyberjar;

import dev.cyberjar.service.CivilianService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.postgresql.PostgreSQLContainer;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
class LiquibaseMigrationTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:18");

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CivilianService civilianService;

    @Test
    void appliesAllChangeSetsOnStartup() {
        List<String> execTypes = jdbcTemplate.queryForList(
                "SELECT exectype FROM databasechangelog ORDER BY orderexecuted", String.class);

        // 004 is skipped by its precondition (the column already exists) and marked as ran
        assertThat(execTypes).containsExactly("EXECUTED", "EXECUTED", "EXECUTED", "MARK_RAN", "EXECUTED");
    }

    @Test
    void seedsSampleData() {
        assertThat(civilianService.findAll())
                .singleElement()
                .satisfies(civilian -> assertThat(civilian.getNationalId()).isEqualTo("IZ-0965437-BM"));

        String manufacturer = jdbcTemplate.queryForObject(
                "SELECT manufacturer FROM cyberware WHERE name = 'OptiSight X3'", String.class);
        assertThat(manufacturer).isEqualTo("SynthForge");
    }
}
