package org.pokemon.mappers;

import org.pokemon.data.dto.PokemonStatsDto;
import org.pokemon.data.entity.PokemonStats;
import org.springframework.stereotype.Component;

@Component
public class PokemonStatsMapper implements IMap<PokemonStatsDto, PokemonStats> {
    @Override
    public PokemonStats map(PokemonStatsDto statDto) {
        return map(statDto, new PokemonStats());
    }

    @Override
    public PokemonStats map(PokemonStatsDto statDto, PokemonStats stat) {
        stat.setEffort(statDto.getEffort());
        stat.setBaseStat(statDto.getBaseStat());

        return stat;
    }
}
