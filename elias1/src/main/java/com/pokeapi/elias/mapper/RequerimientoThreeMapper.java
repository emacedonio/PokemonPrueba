package com.pokeapi.elias.mapper;

import com.pokeapi.elias.dto.RequerimientoThreeRequest;
import com.pokeapi.elias.entity.pokemonEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface RequerimientoThreeMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "moves", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    pokemonEntity toUpdatePokemonEntity(@MappingTarget pokemonEntity entity, RequerimientoThreeRequest request);

}
