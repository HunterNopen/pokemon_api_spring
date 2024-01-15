package org.pokemon.mappers;

import org.pokemon.data.dto.StatDto;
import org.pokemon.data.entity.Stat;
import org.springframework.stereotype.Component;

@Component
public class StatMapper implements IMap<StatDto, Stat> {
    @Override
    public Stat map(StatDto statDto) {
        return map(statDto, new Stat());
    }

    @Override
    public Stat map(StatDto statDto, Stat stat) {
        stat.setName(statDto.getName());
        stat.setUrl(statDto.getUrl());

        return stat;
    }
}
