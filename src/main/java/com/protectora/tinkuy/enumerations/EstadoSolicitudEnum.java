package com.protectora.tinkuy.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoSolicitudEnum {

    PENDIENTE("Pendiente"),
    ESPERANDO_CUESTIONARIO("Esperando cuestionario"),
    ESPERANDO_REVISION("Esperando revisión"),
    ESPERANDO_CONFIRMACION("Esperando confirmación"),
    EN_TRAMITE("En trámite"),
    APROBADA("Aprobada"),
    RECHAZADA("Rechazada"),
    CANCELADA("Cancelada");

    private final String etiqueta;
}
