package com.protectora.tinkuy.entities;

import com.protectora.tinkuy.enumerations.TipoDocumentoIdentidadEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"pais", "persona"})
@Table(name = "datos_legales_persona", uniqueConstraints = {@UniqueConstraint(name = "uk_datos_legales_documento", columnNames = {"tipo_doc_identidad", "numero_doc_identidad"})})
@Entity
public class DatosLegalesPersona {

    @Id
    @Column(name = "persona_id")
    private Long id;

    @MapsId
    @ManyToOne(optional = false)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_doc_identidad", nullable = false, length = 15)
    private TipoDocumentoIdentidadEnum tipoDocIdentidad;

    @Column(name = "numero_doc_identidad", nullable = false, length = 10)
    private String numeroDocIdentidad;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "direccion_basica", nullable = false)
    private String direccionBasica;

    @Column(name = "direccion_detalles")
    private String direccionDetalles;

    @Column(name = "cod_postal", nullable = false, length = 20)
    private String codPostal;

    @Column(nullable = false, length = 100)
    private String ciudad;

    @Column(name = "provincia_estado", nullable = false, length = 100)
    private String provinciaEstado;

    @Column(name = "fecha_supresion_legal")
    private LocalDateTime fechaSupresionLegal;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

}
