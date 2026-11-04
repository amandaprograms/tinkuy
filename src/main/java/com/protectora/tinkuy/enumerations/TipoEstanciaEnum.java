package com.protectora.tinkuy.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoEstanciaEnum {

    PROTECTORA("Protectora"),
    ACOGIDA("Acogida"),
    ADOPTANTE("Adoptante"),
    OTRO("Otro");

    private final String etiqueta;
}
