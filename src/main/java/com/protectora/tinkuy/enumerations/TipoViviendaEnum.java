package com.protectora.tinkuy.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoViviendaEnum {

    PISO("Piso"),
    CASA("Casa"),
    CASA_JARDIN("Casa con jardín"),
    OTRO("Otra vivienda");

    private final String etiqueta;
}
