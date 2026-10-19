package com.pokeapi.elias.mapper;

import com.pokeapi.elias.dto.RequerimientoFourRequest;
import com.pokeapi.elias.entity.pokemonEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-09-04T23:08:31-0600",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-java-compiler-worker-9.7.1.jar, environment: Java 25.0.4.1 (Eclipse Adoptium)"
)
@Component
public class RequerimientoFourMapperImpl implements RequerimientoFourMapper {

    @Override
    public pokemonEntity toPokemonEntity(RequerimientoFourRequest request) {
        if ( request == null ) {
            return null;
        }

        pokemonEntity pokemonEntity = new pokemonEntity();

        pokemonEntity.setName( request.name() );
        pokemonEntity.setType_1( request.type_1() );
        pokemonEntity.setType_2( request.type_2() );
        pokemonEntity.setDescription( request.description() );
        pokemonEntity.setWeight( request.weight() );
        pokemonEntity.setHeight( request.height() );
        pokemonEntity.setMegaEvolves( request.megaEvolves() );
        pokemonEntity.setEvolves_level( request.evolves_level() );

        return pokemonEntity;
    }
}
