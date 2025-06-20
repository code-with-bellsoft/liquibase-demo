package dev.cyberjar;

import dev.cyberjar.service.CivilianService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiquibaseDemoApp implements CommandLineRunner {

    private final CivilianService civilianService;

    public LiquibaseDemoApp(CivilianService civilianService) {
        this.civilianService = civilianService;
    }

    public static void main(String[] args) {
        SpringApplication.run(LiquibaseDemoApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Civilians Registered in NeuroWatch:");
        civilianService.findAll().forEach(civilian -> {
            System.out.printf("- National ID: %s | Under surveillance: %s%n",
                    civilian.getNationalId(), civilian.isUnderSurveillance());
        });
    }
}


