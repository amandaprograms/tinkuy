package com.protectora.tinkuy.entities;

import com.protectora.tinkuy.enumerations.EstadoSolicitudEnum;
import com.protectora.tinkuy.enumerations.PrioridadSolicitudEnum;
import com.protectora.tinkuy.enumerations.TipoSolicitudEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"persona", "usuarioResolucion", "usuarioCancelacion"})
@Table(name = "solicitud")
@Entity
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoSolicitudEnum tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private PrioridadSolicitudEnum prioridad;

    @Column(name = "fecha_solicitud", nullable = false)
    private LocalDateTime fechaSolicitud;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private EstadoSolicitudEnum estado;

    @Column(name = "fecha_resolucion")
    private LocalDateTime fechaResolucion;

    @Lob
    @Column(name = "motivo_resolucion")
    private String motivoResolucion;

    @Column(name = "fecha_cancelacion")
    private LocalDateTime fechaCancelacion;

    @Lob
    @Column(name = "motivo_cancelacion")
    private String motivoCancelacion;

    @Lob
    @Column(name = "comentarios_solicitud")
    private String comentariosSolicitud;

    @Lob
    @Column(name = "comentarios_internos")
    private String comentariosInternos;

    @ManyToOne(optional = false)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "usuario_resolucion_id")
    private Usuario usuarioResolucion;

    @ManyToOne
    @JoinColumn(name = "usuario_cancelacion_id")
    private Usuario usuarioCancelacion;
}
