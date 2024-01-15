package org.pokemon.mappers;

import org.pokemon.data.dto.PokemonDto;
import org.pokemon.data.entity.Pokemon;
import org.springframework.stereotype.Component;

@Component
public class PokemonMapper implements IMap<PokemonDto, Pokemon> {
    @Override
    public Pokemon map(PokemonDto pokemonDto) {
        return map(pokemonDto, new Pokemon());
    }

    @Override
    public Pokemon map(PokemonDto pokemonDto, Pokemon pokemon) {
        pokemon.setName(pokemonDto.getName());
        pokemon.setBaseExperience(pokemonDto.getBaseExperience());
        pokemon.setHeight(pokemonDto.getHeight());
        pokemon.setDefault(pokemonDto.getIsDefault());
        pokemon.setOrderNumber(pokemonDto.getOrder());
        pokemon.setWeight(pokemonDto.getWeight());
        pokemon.setLocationAreaEncounters(pokemonDto.getLocationAreaEncounters());

        return pokemon;
    }
}
