package org.pokemon.data.repositories;

import org.pokemon.data.dto.PokemonStatsDto;
import org.pokemon.data.entity.PokemonHeldItems;
import org.pokemon.data.entity.PokemonStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PokemonStatRepo extends JpaRepository<PokemonStats, Long> {
    @Query("SELECT st FROM PokemonStats st JOIN st.pokemon pokemon JOIN st.stat ab WHERE pokemon.name=:pokemonName AND ab.name=:statName")
    PokemonStats findStat(@Param("statName") String statName, @Param("pokemonName") String pokemonName);

    @Modifying
    @Query("DELETE FROM PokemonStats st WHERE st.id=:statId AND st.pokemon.id=:pokemonId")
    void deletePokemonStat(@Param("pokemonId") Long pokemonId, @Param("statId") Long statId);

}
