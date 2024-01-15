package org.pokemon.controllers;

import lombok.RequiredArgsConstructor;
import org.pokemon.data.dto.PokemonDto;
import org.pokemon.data.dto.PokemonSummarizingDto;
import org.pokemon.data.entity.Pokemon;
import org.pokemon.services.IServiceRequests;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/myPokemons")
public class ControllerWebPokemon {

    private final IServiceRequests service;

//    @GetMapping("/bestiary")
//    public ResponseEntity<List<PokemonSummarizingDto>> getAllPokemons(){
//        return ResponseEntity.ok(service.getAllPokemons());
//    }

    @GetMapping("/bestiary")
    public String getIndexView(Model model){
        model.addAttribute("pokemon", service.getAllPokemons());
        return "index";
    }

    @GetMapping("/bestiary/{id}")
    public String getPokemonInfo(Model model, @PathVariable Long id){
        model.addAttribute("pokemon", service.getPokemon(id));
        model.addAttribute("abilities", service.getAllAbilities(id));
        model.addAttribute("stats", service.getAllStats(id));
        model.addAttribute("types", service.getAllTypes(id));
        model.addAttribute("heldItems", service.getHeldItem(id));
        model.addAttribute("sprites", service.getSprites(id));

        return "pokemon_index";
    }

    @GetMapping("/trainPokemon")
    public String addPokemonIndex(Model model){
        model.addAttribute("pokemon", new PokemonDto());
        return "add_pokemon";
    }

    @PostMapping("/trainPokemon")
    public String addPokemon(PokemonDto pokemon, RedirectAttributes redirectAttributes){
        service.savePokemon(pokemon);
        redirectAttributes.addFlashAttribute("successMessage", "pokemon");
        return "redirect:/myPokemons/bestiary";
    }

    @GetMapping("/deletePokemon/{id}")
    public String deletePokemon(@PathVariable Long id){
        service.deletePokemon(id);
        return "redirect:/myPokemons/bestiary";
    }

    @GetMapping("/editPokemon/{id}")
    public String editPokemonIndex(@PathVariable Long id, Model model){
        Pokemon pokemon=service.findPokemonById(id);
        if (pokemon==null){
            return "redirect:/myPokemons/bestiary";
        }
        model.addAttribute("pokemon", pokemon);
        model.addAttribute("abilities", pokemon.getAbilities());
        model.addAttribute("stats", pokemon.getStats());
        model.addAttribute("types", pokemon.getTypes());
        model.addAttribute("heldItems", pokemon.getHeldItems());
        model.addAttribute("sprites", pokemon.getSprites());
        model.addAttribute("index", 0);
        return "edit_pokemon";
    }

    @PostMapping("/editPokemon/{id}")
    public String editPokemon(@PathVariable Long id, Pokemon pokemon, RedirectAttributes redirectAttributes){
        service.updatePokemon(id, pokemon);
        redirectAttributes.addFlashAttribute("successMessage", "animal");
        return "redirect:/myPokemons/bestiary";
    }

    @GetMapping("/deletePokemonAbility/{pokemonId}AND{abilityId}")
    public String deletePokemonAbility(@PathVariable Long pokemonId, @PathVariable Long abilityId){
        service.deleteAbility(pokemonId, abilityId);
        return "redirect:/myPokemons/editPokemon/"+pokemonId;
    }

    @GetMapping("/deletePokemonType/{pokemonId}AND{typeId}")
    public String deletePokemonType(@PathVariable Long pokemonId, @PathVariable Long typeId){
        service.deleteType(pokemonId, typeId);
        return "redirect:/myPokemons/editPokemon/"+pokemonId;
    }

    @GetMapping("/deletePokemonSprite/{pokemonId}AND{spriteId}")
    public String deletePokemonSprite(@PathVariable Long pokemonId, @PathVariable Long spriteId){
        service.deleteSprite(pokemonId, spriteId);
        return "redirect:/myPokemons/editPokemon/"+pokemonId;
    }

    @GetMapping("/deletePokemonItem/{pokemonId}AND{itemId}")
    public String deletePokemonItem(@PathVariable Long pokemonId, @PathVariable Long itemId){
        service.deleteItem(pokemonId, itemId);
        return "redirect:/myPokemons/editPokemon/"+pokemonId;
    }

    @GetMapping("/deletePokemonStat/{pokemonId}AND{statId}")
    public String deletePokemonStat(@PathVariable Long pokemonId, @PathVariable Long statId){
        service.deleteStat(pokemonId, statId);
        return "redirect:/myPokemons/editPokemon/"+pokemonId;
    }
}
