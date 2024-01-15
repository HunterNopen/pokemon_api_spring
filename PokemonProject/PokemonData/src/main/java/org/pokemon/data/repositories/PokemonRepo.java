package org.pokemon.data.repositories;

import org.pokemon.data.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepo extends JpaRepository<Pokemon, Long> {
    Pokemon findPokemonByName(String Name);
}
