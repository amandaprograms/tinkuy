package com.protectora.tinkuy.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "documento_vinculante")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class DocumentoVinculante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_firma", nullable = false)
    private LocalDate fechaFirma;

    @Column(name = "fecha_anulacion")
    private LocalDateTime fechaAnulacion;

    @Lob
    @Column(name = "motivo_anulacion")
    private String motivoAnulacion;

    @Column(name = "fecha_resolucion")
    private LocalDateTime fechaResolucion;

    @Lob
    @Column(name = "motivo_resolucion")
    private String motivoResolucion;

    @Column(name = "url_pdf", length = 500)
    private String urlPdf;

    @Column(name = "hash_integridad", nullable = false, length = 64)
    private String hashIntegridad;
}
