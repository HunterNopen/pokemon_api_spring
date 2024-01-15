package org.pokemon.mappers;

import org.pokemon.data.dto.TypeDto;
import org.pokemon.data.entity.Type;
import org.springframework.stereotype.Component;

@Component
public class TypeMapper implements IMap<TypeDto, Type> {
    @Override
    public Type map(TypeDto typeDto) {
        return map(typeDto, new Type());
    }

    @Override
    public Type map(TypeDto typeDto, Type type) {
        type.setName(typeDto.getName());
        type.setUrl(typeDto.getUrl());

        return type;
    }
}
