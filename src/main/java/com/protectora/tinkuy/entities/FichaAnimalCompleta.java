package com.protectora.tinkuy.entities;

import com.protectora.tinkuy.enumerations.Compatibilidad;
import com.protectora.tinkuy.enumerations.EstadoSaludAnimal;
import com.protectora.tinkuy.enumerations.MotivoUrgencia;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "animal")
@ToString(exclude = "animal")
@IdClass(FichaAnimalCompletaId.class)
@Table(name="ficha_animal_completa")
@Entity
public class FichaAnimalCompleta {

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name="animal_id", nullable = false)
    private Animal animal;

    @Column(name = "num_microchip", unique = true, length = 15)
    private String numMicrochip;

    @Column(name = "fecha_alta", nullable = false)
    private LocalDateTime fechaAlta;

    private boolean urgente;

    @Enumerated(EnumType.STRING)
    @Column(name = "motivo_urgencia", length = 30)
    private MotivoUrgencia motivoUrgencia;

    @Lob
    @Column(name = "detalle_urgencia")
    private String detalleUrgencia;

    @Column(name = "fecha_fallec")
    private LocalDate fechaFallec;

    @Column(name = "es_fecha_fallec_estimada")
    private Boolean esFechaFallecEstimada;

    @Lob
    @Column(name = "historia")
    private String historia;

    @Enumerated(EnumType.STRING)
    @Column(name = "desparasitado_externo", length = 15)
    private EstadoSaludAnimal desparasitadoExterno;

    @Enumerated(EnumType.STRING)
    @Column(name = "desparasitado_interno", length = 15)
    private EstadoSaludAnimal desparasitadoInterno;

    @Enumerated(EnumType.STRING)
    @Column(name = "vacunas_al_dia", length = 15)
    private EstadoSaludAnimal vacunasAlDia;

    @Enumerated(EnumType.STRING)
    @Column(name = "compatibilidad_perros", length = 15)
    private Compatibilidad compatibilidadPerros;

    @Enumerated(EnumType.STRING)
    @Column(name = "compatibilidad_gatos", length = 15)
    private Compatibilidad compatibilidadGatos;

    @Enumerated(EnumType.STRING)
    @Column(name = "compatibilidad_ninos", length = 15)
    private Compatibilidad compatibilidadNinos;

}
