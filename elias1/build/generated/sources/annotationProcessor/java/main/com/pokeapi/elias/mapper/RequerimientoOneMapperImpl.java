package com.pokeapi.elias.mapper;

import com.pokeapi.elias.dto.PokemonResponse;
import com.pokeapi.elias.entity.pokemonEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-09-04T22:40:44-0600",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-java-compiler-worker-9.7.1.jar, environment: Java 25.0.4.1 (Eclipse Adoptium)"
)
@Component
public class RequerimientoOneMapperImpl implements RequerimientoOneMapper {

    @Override
    public List<PokemonResponse> toPokemonResponseList(List<pokemonEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PokemonResponse> list = new ArrayList<PokemonResponse>( entities.size() );
        for ( pokemonEntity pokemonEntity : entities ) {
            list.add( pokemonEntityToPokemonResponse( pokemonEntity ) );
        }

        return list;
    }

    protected PokemonResponse pokemonEntityToPokemonResponse(pokemonEntity pokemonEntity) {
        if ( pokemonEntity == null ) {
            return null;
        }

        int id = 0;
        String name = null;

        if ( pokemonEntity.getId() != null ) {
            id = pokemonEntity.getId();
        }
        name = pokemonEntity.getName();

        PokemonResponse pokemonResponse = new PokemonResponse( id, name );

        return pokemonResponse;
    }
}
