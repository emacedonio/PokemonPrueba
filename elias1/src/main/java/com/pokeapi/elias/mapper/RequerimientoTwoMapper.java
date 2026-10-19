package com.pokeapi.elias.mapper;

import com.pokeapi.elias.dto.RequerimientoTwoResponse;
import com.pokeapi.elias.entity.movesEntity;
import com.pokeapi.elias.entity.pokemonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RequerimientoTwoMapper {

    @Mapping(target = "types", expression = "java(toTypesList(entity))")
    @Mapping(target = "moves", source = "entity.moves")
    RequerimientoTwoResponse toRequerimientoTwoResponse(pokemonEntity entity);

    @Mapping(target = "type_1", source = "entity.type_1")
    @Mapping(target = "type_2", source = "entity.type_2")
    RequerimientoTwoResponse.typesList toRequerimientoTwoResponseTypes(pokemonEntity entity);

    default List<RequerimientoTwoResponse.typesList> toTypesList(pokemonEntity entity) {
        return List.of(toRequerimientoTwoResponseTypes(entity));
    }

    RequerimientoTwoResponse.movesList toMovesList(movesEntity move);

    List<RequerimientoTwoResponse.movesList> toMovesListResponse(List<movesEntity> moves);
}