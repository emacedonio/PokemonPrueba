package com.pokeapi.elias.mapper;

import com.pokeapi.elias.dto.RequerimientoThreeRequest;
import com.pokeapi.elias.entity.pokemonEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-09-04T23:08:31-0600",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-java-compiler-worker-9.7.1.jar, environment: Java 25.0.4.1 (Eclipse Adoptium)"
)
@Component
public class RequerimientoThreeMapperImpl implements RequerimientoThreeMapper {

    @Override
    public pokemonEntity toUpdatePokemonEntity(pokemonEntity entity, RequerimientoThreeRequest request) {
        if ( request == null ) {
            return entity;
        }

        if ( request.name() != null ) {
            entity.setName( request.name() );
        }
        if ( request.type_1() != null ) {
            entity.setType_1( request.type_1() );
        }
        if ( request.type_2() != null ) {
            entity.setType_2( request.type_2() );
        }
        if ( request.description() != null ) {
            entity.setDescription( request.description() );
        }
        if ( request.weight() != null ) {
            entity.setWeight( request.weight() );
        }
        if ( request.height() != null ) {
            entity.setHeight( request.height() );
        }
        if ( request.megaEvolves() != null ) {
            entity.setMegaEvolves( request.megaEvolves() );
        }
        if ( request.evolves_level() != null ) {
            entity.setEvolves_level( request.evolves_level() );
        }

        return entity;
    }
}
