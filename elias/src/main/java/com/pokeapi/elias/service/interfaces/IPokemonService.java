package com.pokeapi.elias.service.interfaces;

import com.pokeapi.elias.dto.*;

import java.util.List;

public interface IPokemonService {

    List<PokemonResponse> getAll();

    RequerimientoTwoResponse getEspecifico(int id);

    ConfirmationResponse updatePokemon(int id, RequerimientoThreeRequest request);

    ConfirmationResponse createPokemon(RequerimientoFourRequest request);

    ConfirmationResponse deletePokemon(int id);

}
