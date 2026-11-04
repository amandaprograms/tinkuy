package com.protectora.tinkuy.dto;

import com.protectora.tinkuy.enumerations.SexoAnimalEnum;
import com.protectora.tinkuy.enumerations.TamanoAnimalEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalesListadoAdminDto {

    private Long id;
    private String archivoUrl;
    private String textoAlt;
    private String nombre;
    private String especie;
    private String estado;
    private SexoAnimalEnum sexo;
    private TamanoAnimalEnum tamano;
    private Integer edad;
    private Boolean esterilizado;
    private Boolean ppp;
    private boolean urgente;
    private String situacion;
}
