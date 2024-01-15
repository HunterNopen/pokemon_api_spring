package org.pokemon.services;

import org.pokemon.data.dto.*;
import org.pokemon.data.entity.Pokemon;

import java.util.List;

public interface IServiceRequests {
    long savePokemon(PokemonDto dto);
    List<PokemonSummarizingDto> getAllPokemons();
    List<PokemonAbilitiesDto> getAllAbilities(long id);
    List<PokemonHeldItemDto> getHeldItem(long id);
    List<PokemonStatsDto> getAllStats(long id);
    List<PokemonTypesDto> getAllTypes(long id);
    PokemonSpritesDto getSprites(long id);
    PokemonDto getPokemon(long id);
    void deletePokemon(long id);
    void updatePokemon(long id, Pokemon dto);
    Pokemon findPokemonById(Long id);
    void deleteAbility(long id, long abilityId);

    void deleteItem(long pokemonId, long itemId);
    void deleteSprite(long pokemonId, long spriteId);
    void deleteStat(long pokemonId, long statId);
    void deleteType(long pokemonId, long typeId);

}
