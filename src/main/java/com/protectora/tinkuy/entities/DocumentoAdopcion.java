package com.protectora.tinkuy.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = "custodiaAnimal")
@Table(name="documento_adopcion")
@Entity
public class DocumentoAdopcion extends DocumentoVinculante{

    @Column(name = "fecha_limite_esterilizacion")
    private LocalDate fechaLimiteEsterilizacion;

    @Column(name = "fecha_esterilizacion_acreditada")
    private LocalDate fechaEsterilizacionAcreditada;

    @ManyToOne(optional = false)
    @JoinColumn(name = "custodia_animal_id", unique = true, nullable = false)
    private CustodiaAnimal custodiaAnimal;
}
