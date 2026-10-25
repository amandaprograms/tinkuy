package com.protectora.tinkuy.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name="pais")
@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "codigo_pais", unique = true, nullable = false, length = 2)
    private String codigoPais;

    @Column(nullable = false, length = 100)
    private String nombre;
}
