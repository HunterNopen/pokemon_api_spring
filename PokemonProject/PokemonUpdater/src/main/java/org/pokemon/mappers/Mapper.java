package org.pokemon.mappers;

import lombok.RequiredArgsConstructor;
import org.pokemon.data.dto.*;
import org.pokemon.data.entity.*;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mapper implements IMapper{
    private final IMap<AbilityDto, Ability> forAbility;
    private final IMap<ItemDto, Item> forItem;
    private final IMap<PokemonDto, Pokemon> forPokemon;
    private final IMap<PokemonAbilitiesDto, PokemonAbilities> forPokemonAbilities;
    private final IMap<PokemonHeldItemDto, PokemonHeldItems> forHeldItems;
    private final IMap<PokemonSpritesDto, PokemonSprites> forPokemonSprites;
    private final IMap<PokemonStatsDto, PokemonStats> forPokemonStats;
    private final IMap<PokemonTypesDto, PokemonTypes> forPokemonTypes;
    private final IMap<StatDto, Stat> forStat;
    private final IMap<TypeDto, Type> forType;

    @Override
    public IMap<AbilityDto, Ability> forAbility() {
        return forAbility;
    }

    @Override
    public IMap<ItemDto, Item> forItem() {
        return forItem;
    }

    @Override
    public IMap<PokemonDto, Pokemon> forPokemon() {
        return forPokemon;
    }

    @Override
    public IMap<PokemonAbilitiesDto, PokemonAbilities> forPokemonAbilities() {
        return forPokemonAbilities;
    }

    @Override
    public IMap<PokemonHeldItemDto, PokemonHeldItems> forHeldItems() {
        return forHeldItems;
    }

    @Override
    public IMap<PokemonSpritesDto, PokemonSprites> forPokemonSprites() {
        return forPokemonSprites;
    }

    @Override
    public IMap<PokemonStatsDto, PokemonStats> forPokemonStats() {
        return forPokemonStats;
    }

    @Override
    public IMap<PokemonTypesDto, PokemonTypes> forPokemonTypes() {
        return forPokemonTypes;
    }

    @Override
    public IMap<StatDto, Stat> forStat() {
        return forStat;
    }

    @Override
    public IMap<TypeDto, Type> forType() {
        return forType;
    }
}
