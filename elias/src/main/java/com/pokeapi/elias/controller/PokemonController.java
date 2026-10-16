package com.pokeapi.elias.controller;


import com.pokeapi.elias.dto.*;
import com.pokeapi.elias.service.interfaces.ILoginService;
import com.pokeapi.elias.service.interfaces.IPokemonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PokemonController {

    private final IPokemonService ipokemonService;
    private final ILoginService iloginService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody @Valid LoginRequest request) {
        log.info("iniciando sesión para usuario: " + request.username());
        return ResponseEntity.ok(iloginService.login(request.username(), request.password()));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PokemonResponse>> getAll() {
        log.info("buscando todos los pokemones...");
        return ResponseEntity.ok(ipokemonService.getAll());
    }

    @GetMapping("/especifico")
    public ResponseEntity<RequerimientoTwoResponse> getEspecifico(@RequestParam int id) {
        log.info("buscando pokemon con id: " + id);
        return ResponseEntity.ok(ipokemonService.getEspecifico(id));
    }

    @PutMapping("/update")
    public ResponseEntity<ConfirmationResponse> updatePokemon(@RequestParam int id, @RequestBody @Valid RequerimientoThreeRequest request) {
        log.info("actualizando pokemon con id: " + id);
        return ResponseEntity.ok(ipokemonService.updatePokemon(id, request));
    }

    @PostMapping("/create")
    public ResponseEntity<ConfirmationResponse> createPokemon(@RequestBody @Valid RequerimientoFourRequest request) {
        log.info("creando nuevo pokemon...");
        return ResponseEntity.ok(ipokemonService.createPokemon(request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ConfirmationResponse> deletePokemon(@RequestParam int id) {
        log.info("eliminando pokemon con id: " + id);
        return ResponseEntity.ok(ipokemonService.deletePokemon(id));
    }
}