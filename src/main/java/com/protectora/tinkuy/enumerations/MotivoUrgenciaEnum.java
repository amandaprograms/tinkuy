package com.protectora.tinkuy.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MotivoUrgenciaEnum {

    SALUD("Salud"),
    SENIOR("Senior"),
    VULNERABILIDAD("Vulnerabilidad"),
    COMPORTAMIENTO("Comportamiento"),
    OTRO("Otro motivo");

    private final String etiqueta;
}
