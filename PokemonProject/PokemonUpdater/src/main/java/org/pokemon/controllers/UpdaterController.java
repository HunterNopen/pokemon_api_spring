package org.pokemon.controllers;

import lombok.RequiredArgsConstructor;
import org.pokemon.logs.LogsService;
import org.pokemon.updater.IUpdatePokemons;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/myPokemons")
@RequiredArgsConstructor
public class UpdaterController {

    private final IUpdatePokemons updater;

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
