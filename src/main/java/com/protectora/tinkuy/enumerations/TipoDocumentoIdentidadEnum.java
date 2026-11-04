package com.protectora.tinkuy.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoDocumentoIdentidadEnum {

    DNI("DNI"),
    NIE("NIE"),
    PASAPORTE("Pasaparte");

    private final String etiqueta;
}
