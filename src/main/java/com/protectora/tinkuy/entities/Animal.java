package com.protectora.tinkuy.entities;

import com.protectora.tinkuy.enumerations.SexoAnimalEnum;
import com.protectora.tinkuy.enumerations.TamanoAnimalEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "raza")
@Table(name = "animal")
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SexoAnimalEnum sexo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TamanoAnimalEnum tamano;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "es_fecha_nac_estimada")
    private Boolean esFechaNacEstimada;

    private Boolean esterilizado;

    private Boolean ppp;

    @ManyToOne(optional = false)
    @JoinColumn(name = "raza_id", nullable = false)
    private Raza raza;

}
