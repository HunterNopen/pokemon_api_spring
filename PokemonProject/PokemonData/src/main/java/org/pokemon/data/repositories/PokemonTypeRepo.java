package org.pokemon.data.repositories;

import org.pokemon.data.entity.PokemonStats;
import org.pokemon.data.entity.PokemonTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PokemonTypeRepo extends JpaRepository<PokemonTypes, Long> {
    @Query("SELECT tp FROM PokemonTypes tp JOIN tp.pokemon pokemon JOIN tp.type ab WHERE pokemon.name=:pokemonName AND ab.name=:typeName")
    PokemonTypes findType(@Param("typeName") String typeName, @Param("pokemonName") String pokemonName);

    @Modifying
    @Query("DELETE FROM PokemonTypes pa WHERE pa.id=:typeId AND pa.pokemon.id=:pokemonId")
    void deletePokemonType(@Param("pokemonId") Long pokemonId, @Param("typeId") Long typeId);
}
