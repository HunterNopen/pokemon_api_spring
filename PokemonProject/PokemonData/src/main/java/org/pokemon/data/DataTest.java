package org.pokemon.data;



import org.pokemon.data.entity.Pokemon;
import org.pokemon.data.entity.PokemonAbilities;
import org.pokemon.data.repositories.ICatalogData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;


@SpringBootApplication(scanBasePackages = "org.pokemon")
public class DataTest implements CommandLineRunner {
    private final ICatalogData db;

    public DataTest(ICatalogData db) {
        this.db = db;
    }

    public static void main(String[] args) {
        SpringApplication.run(DataTest.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        var pokemon=new Pokemon();
//        pokemon.setId(5L);
//
//        var abilities=new ArrayList<PokemonAbilities>();
//        var ability=new PokemonAbilities();
//        ability.setPokemon(pokemon);
//        abilities.add(ability);
//        pokemon.setAbilities(abilities);
//
//        db.getPokemons().save(pokemon);
    }
}