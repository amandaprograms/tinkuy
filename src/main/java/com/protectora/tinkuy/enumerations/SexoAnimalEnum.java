package com.protectora.tinkuy.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SexoAnimalEnum {

    MACHO("Macho"),
    HEMBRA("Hembra"),
    DESCONOCIDO("Desconocido");

    private final String etiqueta;
}
