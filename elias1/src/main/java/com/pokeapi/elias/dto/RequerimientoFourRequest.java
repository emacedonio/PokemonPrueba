package com.pokeapi.elias.dto;

import java.util.List;

public record RequerimientoFourRequest(
        String name,
        String type_1,
        String type_2,
        String description,
        Double weight,
        Double height,
        Boolean megaEvolves,
        Integer evolves_level,
        List<movesList> moves
) {
    public record movesList(
            Integer id
    ) {
    }
}