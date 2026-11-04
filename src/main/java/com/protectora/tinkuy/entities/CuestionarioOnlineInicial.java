package com.protectora.tinkuy.entities;

import com.protectora.tinkuy.enumerations.TipoViviendaEnum;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "solicitud")
@Table(name = "cuestionario_hogar")
@Entity
public class CuestionarioOnlineInicial {

    @Id
    @Column(name = "solicitud_id")
    private Long id;

    @MapsId
    @ManyToOne(optional = false)
    @JoinColumn(name = "solicitud_id", nullable = false)
    private Solicitud solicitud;

    @Column(name = "num_ninos_menos_6_anios", nullable = false)
    private Integer numNinosMenos6Anios;

    @Column(name = "num_ninos_mas_6_anios", nullable = false)
    private Integer numNinosMas6Anios;

    @Column(name = "num_perros", nullable = false)
    private Integer numPerros;

    @Column(name = "num_gatos", nullable = false)
    private Integer numGatos;

    @Column(name = "num_otros", nullable = false)
    private Integer numOtros;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_vivienda", nullable = false, length = 20)
    private TipoViviendaEnum tipoViviendaEnum;

    @Column(name = "dispone_licencia_ppp", nullable = false)
    private boolean disponeLicenciaPpp;

    @Column(name = "duracion_max_meses")
    private Integer duracionMaxMeses;
}
