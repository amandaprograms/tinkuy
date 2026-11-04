package com.protectora.tinkuy.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoSolicitudEnum {

    ADOPCION("Adopción"),
    ACOGIDA("Acogida"),
    ANUNCIO("Anuncio");

    private final String etiqueta;
}
