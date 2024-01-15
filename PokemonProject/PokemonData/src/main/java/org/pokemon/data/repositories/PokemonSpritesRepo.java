package org.pokemon.data.repositories;

import org.pokemon.data.entity.PokemonSprites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PokemonSpritesRepo extends JpaRepository<PokemonSprites, Long> {
    PokemonSprites findByPokemonName(String pokemonName);

    @Modifying
    @Query("DELETE FROM PokemonSprites pa WHERE pa.id=:spriteId AND pa.pokemon.id=:pokemonId")
    void deleteSprite(@Param("pokemonId") Long pokemonId, @Param("spriteId") Long spriteId);

    @Modifying
    @Query("UPDATE Pokemon p SET p.sprites=null WHERE p.sprites.id=:spriteId")
    void deleteSpriteOfPokemon(@Param("spriteId") Long spriteId);
}
