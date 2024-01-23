package org.pokemon.updater;

import com.github.dozermapper.core.DozerBeanMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pokemon.client.settings.IPokemonClient;
import org.pokemon.data.dto.*;
import org.pokemon.data.entity.Pokemon;
import org.pokemon.data.entity.PokemonAbilities;
import org.pokemon.data.repositories.AbilitiesRepo;
import org.pokemon.data.repositories.ICatalogData;
import org.pokemon.mappers.IMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
@Slf4j
@RequiredArgsConstructor
public class PokemonsUpdaterService implements IUpdatePokemons{

    private final ICatalogData db;
    private final IPokemonClient client;
    private final IMapper mapper;

    @Override
    public void getPokemon(String name) {
        //db.getPokemons().save(mapper.forPokemon().map(client.getPokemonByName(name)));
        var pokemonDto=client.getPokemonByName(name);
        savePokemon(pokemonDto);
        log.info("Processed the pokemon API data: {}",pokemonDto);
    }
    @Override
    public void savePokemon(PokemonDto pokemonDto){
        if (db.getPokemons().findPokemonByName(pokemonDto.getName())!=null){
            return;
        }
        var pokemonDb=mapper.forPokemon().map(pokemonDto);
        db.getPokemons().save(pokemonDb);

        saveAbilities(pokemonDto.getAbilities(), pokemonDb);
        saveHeldItems(pokemonDto.getHeldItems(), pokemonDb);
        saveStats(pokemonDto.getStats(), pokemonDb);
        saveTypes(pokemonDto.getTypes(), pokemonDb);
        saveSprites(pokemonDto.getSprites(), pokemonDb);

        db.getPokemons().save(pokemonDb);
    }

    public void saveAbilities(List<PokemonAbilitiesDto> abilitiesDto, Pokemon pokemonDb){
        for (PokemonAbilitiesDto abilities:abilitiesDto){
            if (db.getAbilities().findAbilities(abilities.getAbility().getName(), pokemonDb.getName()).isPresent() || abilities.getAbility()==null){
                return;
            }

            var abilitiesDb=mapper.forPokemonAbilities().map(abilities);

            var abilityDb=mapper.forAbility().map(abilities.getAbility());

            if (db.getAbility().findByName(abilityDb.getName())==null){
                db.getAbility().save(abilityDb);
            }
            else {
                abilityDb=db.getAbility().findByName(abilityDb.getName());
            }
            abilitiesDb.setAbility(abilityDb);
            abilitiesDb.setPokemon(pokemonDb);
            db.getAbilities().save(abilitiesDb);
            pokemonDb.getAbilities().add(abilitiesDb);
        }
    }

    private void saveHeldItems(List<PokemonHeldItemDto> heldItemsDto, Pokemon pokemonDb) {
        for (PokemonHeldItemDto items:heldItemsDto){
            if (db.getHeldItems().findHeldItem(items.getItem().getName(), pokemonDb.getName())!=null || items.getItem()==null){
                return;
            }

            var heldItemsDb=mapper.forHeldItems().map(items);

            var item=mapper.forItem().map(items.getItem());

            if (db.getItem().findByName(item.getName())==null){
                db.getItem().save(item);
            }
            else {
                item=db.getItem().findByName(item.getName());
            }
            heldItemsDb.setItem(item);
            heldItemsDb.setPokemon(pokemonDb);
            db.getHeldItems().save(heldItemsDb);
            pokemonDb.getHeldItems().add(heldItemsDb);
        }
    }

    private void saveStats(List<PokemonStatsDto> statsDto, Pokemon pokemonDb) {
        for (PokemonStatsDto stats:statsDto){
            if (db.getHeldItems().findHeldItem(stats.getStat().getName(), pokemonDb.getName())!=null || stats.getStat()==null){
                return;
            }

            var pokemonStatDb=mapper.forPokemonStats().map(stats);

            var statDb=mapper.forStat().map(stats.getStat());

            if (db.getStat().findByName(statDb.getName())==null){
                db.getStat().save(statDb);
            }
            else {
                statDb=db.getStat().findByName(statDb.getName());
            }
            pokemonStatDb.setStat(statDb);
            pokemonStatDb.setPokemon(pokemonDb);
            db.getStats().save(pokemonStatDb);
            pokemonDb.getStats().add(pokemonStatDb);
        }
    }

    private void saveTypes(List<PokemonTypesDto> typesDto, Pokemon pokemonDb) {
        for (PokemonTypesDto types:typesDto){
            if (db.getTypes().findType(types.getType().getName(), pokemonDb.getName())!=null || types.getType()==null){
                return;
            }

            var pokemonTypeDb=mapper.forPokemonTypes().map(types);

            var typeDb=mapper.forType().map(types.getType());

            if (db.getType().findByName(typeDb.getName())==null){
                db.getType().save(typeDb);
            }
            else {
                typeDb=db.getType().findByName(typeDb.getName());
            }
            pokemonTypeDb.setType(typeDb);
            pokemonTypeDb.setPokemon(pokemonDb);
            db.getTypes().save(pokemonTypeDb);
            pokemonDb.getTypes().add(pokemonTypeDb);
        }
    }

    private void saveSprites(PokemonSpritesDto spritesDto, Pokemon pokemonDb) {
        if (db.getSprites().findByPokemonName(pokemonDb.getName())!=null || spritesDto==null){
            return;
        }
        var spriteDb=mapper.forPokemonSprites().map(spritesDto);
        spriteDb.setPokemon(pokemonDb);
        db.getSprites().save(spriteDb);
        pokemonDb.setSprites(spriteDb);
    }

    @Override
    public void getPokemonsLimit(int limit) {
        var resultsDto=client.getPokemons(limit);
        var pokemonsDto=resultsDto.getResults();
        pokemonsDto.forEach(p->getPokemon(p.getName()));
        log.info("Processed the pokemon API data: {}",pokemonsDto);
    }
}
