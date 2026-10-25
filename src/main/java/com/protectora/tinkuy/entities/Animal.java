package com.protectora.tinkuy.entities;

import com.protectora.tinkuy.enumerations.EstadoSaludAnimal;
import com.protectora.tinkuy.enumerations.SexoAnimal;
import com.protectora.tinkuy.enumerations.TamanoAnimal;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "raza")
@Table(name="animal")
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SexoAnimal sexo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TamanoAnimal tamano;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "es_fecha_nac_estimada")
    private Boolean esFechaNacEstimada;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EstadoSaludAnimal esterilizado;

    @Column(name = "es_ppp", nullable = false)
    private boolean esPpp;

    @ManyToOne(optional = false)
    @JoinColumn(name="raza_id", nullable = false)
    private Raza raza;

}
