package com.protectora.tinkuy.dto;

import com.protectora.tinkuy.enumerations.CategoriaEdadEnum;
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
public class AnimalesFiltrosAdminDto {

    private String estado;
    private String situacion;
    private SexoAnimalEnum sexo;
    private TamanoAnimalEnum tamano;
    private CategoriaEdadEnum edad;
    private Boolean ppp;
    private Boolean urgente;
    private String esterilizado;
    private Long especieId;

}
