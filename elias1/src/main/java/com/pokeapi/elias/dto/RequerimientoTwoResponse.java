package com.pokeapi.elias.dto;

import java.util.List;

public record RequerimientoTwoResponse(
        String name,
        List<typesList> types,
        double height,
        double weight,
        String description,
        List<movesList> moves

) {
    public record typesList(
            String type_1,
            String type_2
    ) {
    }

    public record movesList(
            String name,
            String type,
            Integer power,
            String accuracy
    ) {
    }
}
