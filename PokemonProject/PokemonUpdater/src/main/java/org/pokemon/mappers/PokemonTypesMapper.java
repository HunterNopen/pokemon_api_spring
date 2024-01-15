package org.pokemon.mappers;

import org.pokemon.data.dto.PokemonTypesDto;
import org.pokemon.data.entity.PokemonTypes;
import org.springframework.stereotype.Component;

@Component
public class PokemonTypesMapper implements IMap<PokemonTypesDto, PokemonTypes> {
    @Override
    public PokemonTypes map(PokemonTypesDto typeDto) {
        return map(typeDto, new PokemonTypes());
    }

    @Override
    public PokemonTypes map(PokemonTypesDto typeDto, PokemonTypes types) {
        types.setSlot(typeDto.getSlot());

        return types;
    }
}
