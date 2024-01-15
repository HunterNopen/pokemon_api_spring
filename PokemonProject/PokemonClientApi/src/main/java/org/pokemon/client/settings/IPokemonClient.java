package org.pokemon.client.settings;

import org.pokemon.data.dto.PagedResultsDto;
import org.pokemon.data.dto.PokemonDto;



public interface IPokemonClient {
    PokemonDto getPokemonByName(String name);
    PagedResultsDto getPokemons(int limit);
}
