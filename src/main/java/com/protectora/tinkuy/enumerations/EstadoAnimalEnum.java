package com.protectora.tinkuy.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoAnimalEnum {

    ACTIVO("Activo"),
    FALLECIDO("Fallecido");

    private final String etiqueta;
}