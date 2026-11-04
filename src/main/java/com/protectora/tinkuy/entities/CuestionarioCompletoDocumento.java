package com.protectora.tinkuy.entities;

import com.protectora.tinkuy.enumerations.TipoDocumentoCuestionarioEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "solicitud")
@Table(name = "documento_cuestionario")
@Entity
public class CuestionarioCompletoDocumento {

    @Id
    @Column(name = "solicitud_id")
    private Long id;

    @MapsId
    @ManyToOne(optional = false)
    @JoinColumn(name = "solicitud_id", nullable = false)
    private Solicitud solicitud;

    @Column(name = "url_pdf", nullable = false, length = 500)
    private String urlPdf;

    @Column(name = "hash_integridad", nullable = false, length = 64)
    private String hashIntegridad;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private TipoDocumentoCuestionarioEnum tipo;
}
