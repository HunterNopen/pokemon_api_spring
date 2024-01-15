package org.pokemon.data.repositories;

public interface ICatalogData {
    AbilitiesRepo getAbilities();
    AbilityRepo getAbility();
    ItemRepo getItem();
    PokemonHeldItemRepo getHeldItems();
    PokemonRepo getPokemons();
    PokemonSpritesRepo getSprites();
    PokemonStatRepo getStats();
    PokemonTypeRepo getTypes();
    StatRepo getStat();
    TypeRepo getType();
}
