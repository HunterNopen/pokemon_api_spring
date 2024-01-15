package org.pokemon;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class PokemonsUpdater {
    public static void main(String[] args) {
        SpringApplication.run(PokemonsUpdater.class, args);
    }
}