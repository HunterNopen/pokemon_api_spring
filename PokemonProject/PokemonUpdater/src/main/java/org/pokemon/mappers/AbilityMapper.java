package org.pokemon.mappers;

import org.pokemon.data.dto.AbilityDto;
import org.pokemon.data.entity.Ability;
import org.springframework.stereotype.Component;

@Component
public class AbilityMapper implements IMap<AbilityDto, Ability> {
    @Override
    public Ability map(AbilityDto abilityDto) {
        return map(abilityDto, new Ability());
    }

    @Override
    public Ability map(AbilityDto abilityDto, Ability ability) {
        ability.setName(abilityDto.getName());
        ability.setUrl(abilityDto.getUrl());
        return ability;
    }
}
