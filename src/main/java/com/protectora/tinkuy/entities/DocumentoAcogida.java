package com.protectora.tinkuy.entities;

import com.protectora.tinkuy.enumerations.TipoDocumentoAcogidaEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = "estanciaAnimal")
@Table(name = "documento_acogida")
@Entity
public class DocumentoAcogida extends DocumentoVinculante {

    @Column(name = "fecha_fin_prevista", nullable = false)
    private LocalDate fechaFinPrevista;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoDocumentoAcogidaEnum tipo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "estancia_animal_id", nullable = false)
    private EstanciaAnimal estanciaAnimal;
}
