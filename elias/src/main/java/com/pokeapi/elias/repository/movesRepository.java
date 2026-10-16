package com.pokeapi.elias.repository;

import com.pokeapi.elias.entity.movesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface movesRepository extends JpaRepository<movesEntity, Integer> {
}
