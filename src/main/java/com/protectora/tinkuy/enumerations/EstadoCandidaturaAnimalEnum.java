package com.protectora.tinkuy.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoCandidaturaAnimalEnum {

    PENDIENTE("Pendiente de confirmación"),
    ESCOGIDO("Escogido"),
    DESCARTADO("Descartado"),
    CANCELADO("Cancelado");

    private final String etiqueta;
}