package com.protectora.tinkuy.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CategoriaEdadEnum {

    CACHORRO("Cachorros"),
    ADULTO("Adultos"),
    SENIOR("Senior");

    private final String etiqueta;

}
