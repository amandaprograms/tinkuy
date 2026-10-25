package com.protectora.tinkuy.entities;

import com.protectora.tinkuy.enumerations.TipoDocumentoCuestionario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "solicitud")
@ToString(exclude = "solicitud")
@IdClass(DocumentoCuestionarioId.class)
@Table(name = "documento_cuestionario")
@Entity
public class DocumentoCuestionario {

    @Id
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
    private TipoDocumentoCuestionario tipo;
}
