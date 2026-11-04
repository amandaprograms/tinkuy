package com.protectora.tinkuy.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoAnuncioEnum {

    PENDIENTE("Pendiente"),
    PUBLICADO("Publicado"),
    RESUELTO("Resuelto"),
    CERRADO("Cerrado");

    private final String etiqueta;
}
