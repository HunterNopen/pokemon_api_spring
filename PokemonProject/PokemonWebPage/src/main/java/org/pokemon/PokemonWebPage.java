package org.pokemon;

import lombok.RequiredArgsConstructor;
import org.pokemon.updater.IUpdatePokemons;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication(scanBasePackages = "org.pokemon")
@EnableJpaRepositories
@RequiredArgsConstructor
public class PokemonWebPage implements CommandLineRunner {
    private final IUpdatePokemons updater;
    public static void main(String[] args) {
        SpringApplication.run(PokemonsUpdater.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        updater.getPokemonsLimit(5);
    }
}