package com.protectora.tinkuy.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SolicitudAnimalId implements Serializable {

    @Column(name = "solicitud_id")
    private Long solicitudId;

    @Column(name = "animal_id")
    private Long animalId;

    @Column(name = "fecha_seleccionado")
    private LocalDateTime fechaSeleccionado;

}
