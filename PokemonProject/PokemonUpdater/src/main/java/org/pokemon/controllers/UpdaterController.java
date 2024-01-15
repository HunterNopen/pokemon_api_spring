package org.pokemon.controllers;

import org.pokemon.updater.IUpdatePokemons;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/myPokemons")
public class UpdaterController {

    private final IUpdatePokemons updater;

    public UpdaterController(IUpdatePokemons updater){
        this.updater=updater;
    }

    @GetMapping("/getByName")
    public ResponseEntity<String> getByName(@RequestParam String name){
        updater.getPokemon(name);
        return ResponseEntity.ok("Ok");
    }

    @GetMapping("/getAll")
    public ResponseEntity<String> getAllByLimit(@RequestParam int limit){
        updater.getPokemonsLimit(limit);
        return ResponseEntity.ok("Ok");
    }

    @GetMapping("/shit")
    public ResponseEntity<String> shit(){
        return ResponseEntity.ok("Ok");
    }

}
