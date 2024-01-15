package org.pokemon.services;

import lombok.RequiredArgsConstructor;
import org.pokemon.data.dto.*;
import org.pokemon.data.entity.Pokemon;
import org.pokemon.data.repositories.AbilityRepo;
import org.pokemon.data.repositories.ICatalogData;
import org.pokemon.mappers.IMapper;
import org.pokemon.updater.IUpdatePokemons;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceWebPokemon implements IServiceRequests{

    private final ICatalogData db;
    private final IMapper mapper;
    private final IUpdatePokemons updater;
    @Override
    public long savePokemon(PokemonDto dto) {
        updater.savePokemon(dto);
        return db.getPokemons().findPokemonByName(dto.getName()).getId();
    }

    @Override
    public List<PokemonSummarizingDto> getAllPokemons() {
        var listPokemons=new ArrayList<PokemonSummarizingDto>();
        db.getPokemons().findAll().forEach(p->  listPokemons.add(new PokemonSummarizingDto(p.getId(), p.getName())));
        return listPokemons;
    }

    @Override
    public PokemonDto getPokemon(long id) {
        var pokemon=db.getPokemons().findById(id).get();
        var dto=new PokemonDto();
        dto.setId(pokemon.getId().intValue());
        dto.setName(pokemon.getName());
        dto.setBaseExperience(pokemon.getBaseExperience());
        dto.setHeight(pokemon.getHeight());
        dto.setIsDefault(pokemon.getDefault());
        dto.setOrder(pokemon.getOrderNumber());
        dto.setWeight(pokemon.getWeight());
        dto.setLocationAreaEncounters(pokemon.getLocationAreaEncounters());

        return dto;
    }

    @Override
    public List<PokemonAbilitiesDto> getAllAbilities(long id) {
        var abilities=db.getPokemons().findById(id).get().getAbilities();
        var resultDto=new ArrayList<PokemonAbilitiesDto>();
        abilities.forEach(a->{
            var ability=new AbilityDto(a.getAbility().getId().intValue(), a.getAbility().getName(), a.getAbility().getUrl());
            var abilitiesDto=new PokemonAbilitiesDto(a.getHidden(), a.getSlot(),ability);
            resultDto.add(abilitiesDto);
        });

        return resultDto;
    }

    @Override
    public List<PokemonHeldItemDto> getHeldItem(long id) {
        var heldItems=db.getPokemons().findById(id).get().getHeldItems();
        var resultDto=new ArrayList<PokemonHeldItemDto>();
        heldItems.forEach(a->{
            var item=new ItemDto(a.getItem().getName(), a.getItem().getUrl());
            var heldItem=new PokemonHeldItemDto(item);
            resultDto.add(heldItem);
        });

        return resultDto;
    }

    @Override
    public List<PokemonStatsDto> getAllStats(long id) {
        var pokemonStats=db.getPokemons().findById(id).get().getStats();
        var resultDto=new ArrayList<PokemonStatsDto>();
        pokemonStats.forEach(a->{
            var stat=new StatDto(a.getStat().getName(), a.getStat().getUrl());
            var pokemonStat=new PokemonStatsDto(a.getEffort(), a.getBaseStat(),stat);
            resultDto.add(pokemonStat);
        });

        return resultDto;
    }

    @Override
    public List<PokemonTypesDto> getAllTypes(long id) {
        var types=db.getPokemons().findById(id).get().getTypes();
        var resultDto=new ArrayList<PokemonTypesDto>();
        types.forEach(a->{
            var type=new TypeDto(a.getType().getName(), a.getType().getUrl());
            var pokemonTypes=new PokemonTypesDto(a.getSlot(), type);
            resultDto.add(pokemonTypes);
        });

        return resultDto;
    }

    @Override
    public PokemonSpritesDto getSprites(long id) {
        var spritesOp=db.getPokemons().findById(id);
        if(spritesOp.isPresent() && spritesOp.get().getSprites()!=null){
            var sprites=spritesOp.get().getSprites();
            return new PokemonSpritesDto(sprites.getFrontDefault(), sprites.getFrontShiny(), sprites.getFrontFemale(), sprites.getFrontShinyFemale(), sprites.getBackDefault(), sprites.getBackShiny(), sprites.getBackFemale(), sprites.getBackShinyFemale());
    }
        else {
            return null;
        }
    }

    @Override
    public void deletePokemon(long id) {
        db.getPokemons().delete(db.getPokemons().findById(id).get());
    }

    @Override
    public void updatePokemon(long id, Pokemon pokemon) {
        pokemon.setId(id);
        db.getPokemons().save(pokemon);
    }

    @Override
    public Pokemon findPokemonById(Long id){
        return db.getPokemons().findById(id).get();
    }

    @Override
    @Transactional
    public void deleteAbility(long pokemonId, long abilityId){
        db.getAbilities().deletePokemonAbility(pokemonId, abilityId);
    }

    @Override
    @Transactional
    public void deleteItem(long pokemonId, long itemId) {
        db.getHeldItems().deletePokemonItem(pokemonId, itemId);
    }

    @Override
    @Transactional
    public void deleteSprite(long pokemonId, long spriteId) {
        db.getSprites().deleteSpriteOfPokemon(spriteId);
        db.getSprites().deleteSprite(pokemonId, spriteId);
    }

    @Override
    @Transactional
    public void deleteStat(long pokemonId, long statId) {
        db.getStats().deletePokemonStat(pokemonId, statId);
    }

    @Override
    @Transactional
    public void deleteType(long pokemonId, long typeId) {
        db.getTypes().deletePokemonType(pokemonId, typeId);
    }

}
