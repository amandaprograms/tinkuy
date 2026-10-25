package com.protectora.tinkuy.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"solicitud", "animal"})
@Table(name = "solicitud_animal")
@Entity
public class SolicitudAnimal {

    @EmbeddedId
    private SolicitudAnimalId id = new SolicitudAnimalId();

    @MapsId("solicitudId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "solicitud_id", nullable = false)
    private Solicitud solicitud;

    @MapsId("animalId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

//    @Column(name = "fecha_seleccionado", nullable = false)
//    private LocalDateTime fechaSeleccionado;

    @Column(name = "fecha_descartado")
    private LocalDateTime fechaDescartado;

    @Lob
    @Column(name = "motivo_descarte")
    private String motivoDescarte;

}
