package com.protectora.tinkuy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalesEstadisticasAdminDto {

    private Long totalAnimales;
    private Long totalUrgentes;
    private Long totalEnAdopcion;
    private Long totalAdoptados;
}
