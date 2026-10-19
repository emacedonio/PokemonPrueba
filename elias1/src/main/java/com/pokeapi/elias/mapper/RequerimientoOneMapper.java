package com.pokeapi.elias.mapper;

import com.pokeapi.elias.dto.PokemonResponse;
import com.pokeapi.elias.entity.pokemonEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RequerimientoOneMapper {

    List<PokemonResponse> toPokemonResponseList(List<pokemonEntity> entities);

}