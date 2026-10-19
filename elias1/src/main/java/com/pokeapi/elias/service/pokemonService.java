package com.pokeapi.elias.service;

import com.pokeapi.elias.dto.*;
import com.pokeapi.elias.entity.movesEntity;
import com.pokeapi.elias.entity.pokemonEntity;
import com.pokeapi.elias.mapper.RequerimientoFourMapper;
import com.pokeapi.elias.mapper.RequerimientoOneMapper;
import com.pokeapi.elias.mapper.RequerimientoThreeMapper;
import com.pokeapi.elias.mapper.RequerimientoTwoMapper;
import com.pokeapi.elias.repository.movesRepository;
import com.pokeapi.elias.repository.pokemonRepository;
import com.pokeapi.elias.service.interfaces.IPokemonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class pokemonService implements IPokemonService {

    private final pokemonRepository pokemonRepository;
    private final movesRepository movesRepository;
    private final RequerimientoOneMapper requerimientoOneMapper;
    private final RequerimientoTwoMapper requerimientoTwoMapper;
    private final RequerimientoThreeMapper requerimientoThreeMapper;
    private final RequerimientoFourMapper requerimientoFourMapper;

    @Transactional(readOnly = true)
    @Override
    public List<PokemonResponse> getAll() {
        List<pokemonEntity> findAll = pokemonRepository.findAll();
        return requerimientoOneMapper.toPokemonResponseList(findAll);
    }

    @Override
    @Transactional(readOnly = true)
    public RequerimientoTwoResponse getEspecifico(int id) {
        pokemonEntity entity = pokemonRepository.findById(id).orElse(null);
        return requerimientoTwoMapper.toRequerimientoTwoResponse(entity);
    }

    @Override
    @Transactional
    public ConfirmationResponse updatePokemon(int id, RequerimientoThreeRequest request) {
        pokemonEntity entity = pokemonRepository.findById(id).orElse(null);
        if (entity != null) {
            requerimientoThreeMapper.toUpdatePokemonEntity(entity, request);
            if (request.moves() != null) {
                List<movesEntity> moves = movesRepository.findAllById(request.moves());
                entity.setMoves(moves);
            }
            pokemonRepository.save(entity);
            return new ConfirmationResponse("Pokémon actualizado exitosamente", id);
        }
        log.warn("Pokemon con id {} no encontrado para actualizar.", id);
        return new ConfirmationResponse("Pokémon no encontrado", id);
    }

    @Override
    @Transactional
    public ConfirmationResponse createPokemon(RequerimientoFourRequest request) {
        pokemonEntity entity = requerimientoFourMapper.toPokemonEntity(request);
        entity.setMoves(List.of());
        pokemonEntity saved = pokemonRepository.save(entity);

        if (request.moves() != null && !request.moves().isEmpty()) {
            List<Integer> moveIds = request.moves().stream()
                    .map(RequerimientoFourRequest.movesList::id)
                    .toList();
            List<movesEntity> moves = movesRepository.findAllById(moveIds);
            saved.setMoves(moves);
            pokemonRepository.save(saved);
        }

        return new ConfirmationResponse("Pokémon creado exitosamente", saved.getId());
    }

    @Override
    @Transactional
    public ConfirmationResponse deletePokemon(int id) {
        if (pokemonRepository.existsById(id)) {
            pokemonRepository.deleteById(id);
            return new ConfirmationResponse("Pokémon eliminado exitosamente", id);
        }
        log.warn("Pokemon con id {} no encontrado para eliminar.", id);
        return new ConfirmationResponse("Pokémon no encontrado", id);
    }
}