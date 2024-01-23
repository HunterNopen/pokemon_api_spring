package org.pokemon.updater;

import org.pokemon.data.dto.PokemonDto;

public interface IUpdatePokemons {
    void getPokemon(String name);
    void savePokemon(PokemonDto pokemonDto);
    void getPokemonsLimit(int limit);

}
