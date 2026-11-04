package com.protectora.tinkuy.entities;

import com.protectora.tinkuy.enumerations.MotivoUrgenciaEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "animal")
@Table(name = "ficha_animal_completa")
@Entity
public class FichaAnimalCompleta {

    @Id
    @Column(name = "animal_id")
    private Long id;

    @MapsId
    @ManyToOne(optional = false)
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @Column(name = "num_microchip", unique = true, length = 15)
    private String numMicrochip;

    @Column(name = "fecha_alta", nullable = false)
    private LocalDateTime fechaAlta;

    private boolean urgente;

    @Enumerated(EnumType.STRING)
    @Column(name = "motivo_urgencia", length = 30)
    private MotivoUrgenciaEnum motivoUrgenciaEnum;

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

    @Column(name = "desparasitado_externo")
    private Boolean desparasitadoExterno;

    @Column(name = "desparasitado_interno")
    private Boolean desparasitadoInterno;

    @Column(name = "vacunas_al_dia")
    private Boolean vacunasAlDia;

    @Column(name = "compatibilidad_perros")
    private Boolean compatibilidadEnumPerros;

    @Column(name = "compatibilidad_gatos")
    private Boolean compatibilidadEnumGatos;

    @Column(name = "compatibilidad_ninos")
    private Boolean compatibilidadEnumNinos;

    @Column(name = "disponible_adopcion")
    private boolean disponibleAdopcion;

    @Column(name = "disponible_acogida")
    private boolean disponibleAcogida;

}
