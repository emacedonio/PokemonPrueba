package com.pokeapi.elias.dto;

import java.util.List;

public record PokemonResponse(
        int id,
        String name
) {
    public record PokemonsResponse(
            List<PokemonResponse> listPokemons
    ) {
    }
}