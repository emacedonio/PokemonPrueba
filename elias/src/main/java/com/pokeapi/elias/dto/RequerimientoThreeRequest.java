package com.pokeapi.elias.dto;

import java.util.List;

public record RequerimientoThreeRequest(

        String type_1,

        String type_2,

        String name,

        String description,

        Double weight,

        Double height,

        Boolean megaEvolves,

        Integer evolves_level,

        List<Integer> moves
) {
}
