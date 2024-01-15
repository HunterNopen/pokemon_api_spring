package org.pokemon.mappers;

import org.pokemon.data.dto.*;
import org.pokemon.data.entity.*;

public interface IMapper {
    IMap<AbilityDto, Ability> forAbility();
    IMap<ItemDto, Item> forItem();
    IMap<PokemonDto, Pokemon> forPokemon();
    IMap<PokemonAbilitiesDto, PokemonAbilities> forPokemonAbilities();
    IMap<PokemonHeldItemDto, PokemonHeldItems> forHeldItems();
    IMap<PokemonSpritesDto, PokemonSprites> forPokemonSprites();
    IMap<PokemonStatsDto, PokemonStats> forPokemonStats();
    IMap<PokemonTypesDto, PokemonTypes> forPokemonTypes();
    IMap<StatDto, Stat> forStat();
    IMap<TypeDto, Type> forType();
}
