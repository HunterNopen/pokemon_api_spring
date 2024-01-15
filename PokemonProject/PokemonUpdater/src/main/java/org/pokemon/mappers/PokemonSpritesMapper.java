package org.pokemon.mappers;

import org.pokemon.data.dto.PokemonSpritesDto;
import org.pokemon.data.entity.PokemonSprites;
import org.springframework.stereotype.Component;

@Component
public class PokemonSpritesMapper implements IMap<PokemonSpritesDto, PokemonSprites> {
    @Override
    public PokemonSprites map(PokemonSpritesDto spritesDto) {
        return map(spritesDto, new PokemonSprites());
    }

    @Override
    public PokemonSprites map(PokemonSpritesDto spritesDto, PokemonSprites sprites) {
        sprites.setFrontDefault(spritesDto.getFrontDefault());
        sprites.setBackShiny(spritesDto.getBackShiny());
        sprites.setFrontFemale(spritesDto.getFrontFemale());
        sprites.setFrontShinyFemale(spritesDto.getFrontShinyFemale());
        sprites.setBackDefault(spritesDto.getBackDefault());
        sprites.setBackShiny(spritesDto.getBackShiny());
        sprites.setBackFemale(spritesDto.getBackFemale());
        sprites.setBackShinyFemale(spritesDto.getBackShinyFemale());

        return sprites;
    }
}
