package org.pokemon.data.repositories;

import org.pokemon.data.entity.PokemonAbilities;
import org.pokemon.data.entity.PokemonHeldItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PokemonHeldItemRepo extends JpaRepository<PokemonHeldItems, Long> {
    @Query("SELECT it FROM PokemonHeldItems it JOIN it.pokemon pokemon JOIN it.item ab WHERE pokemon.name=:pokemonName AND ab.name=:itemName")
    PokemonHeldItems findHeldItem(@Param("itemName") String itemName, @Param("pokemonName") String pokemonName);

    @Modifying
    @Query("DELETE FROM PokemonHeldItems pa WHERE pa.id=:itemId AND pa.pokemon.id=:pokemonId")
    void deletePokemonItem(@Param("pokemonId") Long pokemonId, @Param("itemId") Long itemId);
}
