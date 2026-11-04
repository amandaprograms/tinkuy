package com.protectora.tinkuy.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TamanoAnimalEnum {

    PEQUENO("Pequeño"),
    MEDIANO("Mediano"),
    GRANDE("Grande"),
    MUY_GRANDE("Muy grande");

    public final String etiqueta;
}
