package com.protectora.tinkuy.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SituacionAnimalEnum {

    DISPONIBLE("Disponible"),
    SOLICITADO("Solicitado"),
    EN_TRAMITE_ADOPCION("En trámite de adopción"),
    EN_REVISION_ADOPCION("En revisión de adopción"),
    ADOPTADO("Adoptado"),
    EN_VALORACION_ACOGIDA("En valoración de acogida"),
    EN_ACOGIDA("En acogida"),
    FALLECIDO("Fallecido"),
    NO_DISPONIBLE("No disponible");

    private final String etiqueta;
}