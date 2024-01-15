package org.pokemon.data.repositories;

import org.pokemon.data.entity.Pokemon;
import org.pokemon.data.entity.PokemonAbilities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface AbilitiesRepo extends JpaRepository<PokemonAbilities, Long> {
    @Query("SELECT pa FROM PokemonAbilities pa JOIN pa.pokemon pokemon JOIN pa.ability ab WHERE pokemon.name = :pokemonName AND ab.name = :abilityName")
    Optional<PokemonAbilities> findAbilities(@Param("abilityName") String abilityName, @Param("pokemonName") String pokemonName);
    @Modifying
    @Query("DELETE FROM PokemonAbilities pa WHERE pa.id=:abilityId AND pa.pokemon.id=:pokemonId")
    void deletePokemonAbility(@Param("pokemonId") Long pokemonId, @Param("abilityId") Long abilityId);

}
