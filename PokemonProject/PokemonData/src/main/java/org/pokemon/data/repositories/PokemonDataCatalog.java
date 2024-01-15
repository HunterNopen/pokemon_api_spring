package org.pokemon.data.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PokemonDataCatalog implements ICatalogData{
    private final AbilitiesRepo abilities;
    private final AbilityRepo ability;
    private final ItemRepo items;
    private final PokemonHeldItemRepo heldItems;
    private final PokemonRepo pokemons;
    private final PokemonSpritesRepo sprites;
    private final PokemonStatRepo stats;
    private final PokemonTypeRepo types;
    private final StatRepo stat;
    private final TypeRepo type;
    @Autowired
    public PokemonDataCatalog(AbilitiesRepo abilities, AbilityRepo ability, ItemRepo items, PokemonHeldItemRepo heldItems, PokemonRepo pokemons, PokemonSpritesRepo sprites, PokemonStatRepo stats, PokemonTypeRepo types, StatRepo stat, TypeRepo type) {
        this.abilities = abilities;
        this.ability = ability;
        this.items = items;
        this.heldItems = heldItems;
        this.pokemons = pokemons;
        this.sprites = sprites;
        this.stats = stats;
        this.types = types;
        this.stat = stat;
        this.type = type;
    }

    @Override
    public AbilitiesRepo getAbilities() {
        return abilities;
    }

    @Override
    public AbilityRepo getAbility() {
        return ability;
    }

    @Override
    public ItemRepo getItem() {
        return items;
    }

    @Override
    public PokemonHeldItemRepo getHeldItems() {
        return heldItems;
    }

    @Override
    public PokemonRepo getPokemons() {
        return pokemons;
    }

    @Override
    public PokemonSpritesRepo getSprites() {
        return sprites;
    }

    @Override
    public PokemonStatRepo getStats() {
        return stats;
    }

    @Override
    public PokemonTypeRepo getTypes() {
        return types;
    }

    @Override
    public StatRepo getStat() {
        return stat;
    }

    @Override
    public TypeRepo getType() {
        return type;
    }
}
