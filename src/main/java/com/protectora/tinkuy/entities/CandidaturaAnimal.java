package com.protectora.tinkuy.entities;

import com.protectora.tinkuy.enumerations.EstadoCandidaturaAnimalEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"solicitud", "animal"})
@Table(name = "candidatura_animal")
@Entity
public class CandidaturaAnimal {

    @EmbeddedId
    private CandidaturaAnimalId id = new CandidaturaAnimalId();

    @MapsId("solicitudId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "solicitud_id", nullable = false)
    private Solicitud solicitud;

    @MapsId("animalId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private EstadoCandidaturaAnimalEnum estado;

    @Column(name = "fecha_respuesta")
    private LocalDateTime fechaRespuesta;

    @Lob
    @Column(name = "motivo_descarte")
    private String motivoDescarte;
}