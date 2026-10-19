package com.pokeapi.elias.repository;

import com.pokeapi.elias.entity.pokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pokemonRepository extends JpaRepository<pokemonEntity, Integer> {

}
