package org.pokemon.mappers;

import org.pokemon.data.dto.PokemonHeldItemDto;
import org.pokemon.data.entity.PokemonHeldItems;
import org.springframework.stereotype.Component;

@Component
public class PokemonHeldItemsMapper implements IMap<PokemonHeldItemDto, PokemonHeldItems> {
    @Override
    public PokemonHeldItems map(PokemonHeldItemDto itemDto) {
        return map(itemDto, new PokemonHeldItems());
    }

    @Override
    public PokemonHeldItems map(PokemonHeldItemDto itemDto, PokemonHeldItems items) {


        return items;
    }
}
