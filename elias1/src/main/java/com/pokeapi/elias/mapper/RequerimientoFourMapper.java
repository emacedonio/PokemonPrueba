package com.pokeapi.elias.mapper;

import com.pokeapi.elias.dto.RequerimientoFourRequest;
import com.pokeapi.elias.entity.pokemonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RequerimientoFourMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "moves", ignore = true)
    pokemonEntity toPokemonEntity(RequerimientoFourRequest request);
}
