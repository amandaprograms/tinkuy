package com.protectora.tinkuy.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "raza", uniqueConstraints = {@UniqueConstraint(name = "uk_raza_especie_nombre", columnNames = {"especie_id", "nombre"})})
@Entity
public class Raza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "especie_id", nullable = false)
    private Especie especie;
}
