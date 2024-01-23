package org.pokemon.mappers;

import org.pokemon.data.dto.PokemonAbilitiesDto;
import org.pokemon.data.entity.PokemonAbilities;
import org.springframework.stereotype.Component;

@Component
public class PokemonAbilityMapper implements IMap<PokemonAbilitiesDto, PokemonAbilities> {
    @Override
    public PokemonAbilities map(PokemonAbilitiesDto abilityDto) {
        return map(abilityDto, new PokemonAbilities());
    }

    @Override
    public PokemonAbilities map(PokemonAbilitiesDto abilityDto, PokemonAbilities ability) {
        ability.setHidden(abilityDto.getIsHidden());
        ability.setSlot(abilityDto.getSlot());

        return ability;
    }
}
