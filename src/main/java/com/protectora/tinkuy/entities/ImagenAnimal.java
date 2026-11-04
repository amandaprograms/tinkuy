package com.protectora.tinkuy.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "animal")
@Table(name="imagen_animal", uniqueConstraints = { @UniqueConstraint(name = "uk_imagen_animal_orden", columnNames = {"animal_id", "orden"})})
@Entity
public class ImagenAnimal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "archivo_url", nullable = false, length = 500)
    private String archivoUrl;

    @Column(name = "texto_alt", nullable = false)
    private String textoAlt;

    @Column(nullable = false)
    private int orden;

    @ManyToOne(optional = false)
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

}
