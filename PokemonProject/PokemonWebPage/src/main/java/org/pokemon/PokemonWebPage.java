package org.pokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "org.pokemon")
@EnableJpaRepositories
public class PokemonWebPage {
    public static void main(String[] args) {
        SpringApplication.run(PokemonsUpdater.class, args);
    }
}