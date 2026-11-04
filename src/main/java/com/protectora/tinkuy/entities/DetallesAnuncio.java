package com.protectora.tinkuy.entities;

import com.protectora.tinkuy.enumerations.EstadoAnuncioEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"solicitud", "animal"})
@Table(name = "detalles_anuncio")
@Entity
public class DetallesAnuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_publicacion", nullable = false)
    private LocalDateTime fechaPublicacion;

    @Column(name = "fecha_cierre")
    private LocalDateTime fechaCierre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private EstadoAnuncioEnum estado;

    @Column(name = "es_perdida_interna", nullable = false)
    private boolean esPerdidaInterna;

    @Column(nullable = false, length = 100)
    private String provincia;

    @Column(nullable = false, length = 100)
    private String localidad;

    @Column(length = 150)
    private String zona;

    @Lob
    private String texto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "solicitud_id")
    private Solicitud solicitud;

}
