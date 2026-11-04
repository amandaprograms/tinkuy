package com.protectora.tinkuy.models;

import com.protectora.tinkuy.enumerations.CategoriaEdadEnum;
import com.protectora.tinkuy.enumerations.SexoAnimalEnum;
import com.protectora.tinkuy.enumerations.TamanoAnimalEnum;

public record AnimalesFiltrosAdmin(
        SexoAnimalEnum sexo,
        TamanoAnimalEnum tamano,
        CategoriaEdadEnum edad,
        Boolean ppp,
        Boolean urgente,
        String estado,
        String esterilizado,
        String situacion,
        Long especieId) {
}