package com.protectora.tinkuy.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UsuarioRolId implements Serializable {

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name="rol_id")
    private Long rolId;

}
