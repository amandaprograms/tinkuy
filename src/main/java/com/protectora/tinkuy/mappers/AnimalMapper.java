package com.protectora.tinkuy.mappers;

import com.protectora.tinkuy.dto.AnimalesListadoAdminDto;
import com.protectora.tinkuy.entities.Animal;
import com.protectora.tinkuy.entities.FichaAnimalCompleta;
import com.protectora.tinkuy.entities.ImagenAnimal;
import org.mapstruct.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class AnimalMapper {

    public List<AnimalesListadoAdminDto> toListadoDtoList(
            List<FichaAnimalCompleta> fichas,
            List<ImagenAnimal> imagenesPrincipales,
            Map<Long, String> situacionesPorAnimal
    ) {
        List<AnimalesListadoAdminDto> listaDto = new ArrayList<>();

        if (fichas != null && !fichas.isEmpty()) {
            Map<Long, ImagenAnimal> imagenesPorAnimal = new HashMap<>();
            if (imagenesPrincipales != null) {
                for (ImagenAnimal imagen : imagenesPrincipales) {
                    if (imagen != null && imagen.getAnimal() != null && imagen.getAnimal().getId() != null) {
                        imagenesPorAnimal.put(imagen.getAnimal().getId(), imagen);
                    }
                }
            }

            for (FichaAnimalCompleta ficha : fichas) {
                if (ficha != null && ficha.getAnimal() != null && ficha.getAnimal().getId() != null) {

                    Animal animal = ficha.getAnimal();
                    ImagenAnimal imagenPrincipal = imagenesPorAnimal.get(animal.getId());

                    String situacion = null;

                    if (situacionesPorAnimal != null) {
                        situacion = situacionesPorAnimal.get(animal.getId());
                    }

                    AnimalesListadoAdminDto dto = toListadoDto(animal, ficha, imagenPrincipal, situacion);

                    if (dto != null) {
                        listaDto.add(dto);
                    }
                }
            }
        }

        return listaDto;
    }

    @Mapping(source = "animal.id", target = "id")
    @Mapping(source = "animal.ppp", target = "ppp")
    @Mapping(source = "situacionCalculada", target = "situacion")
    public abstract AnimalesListadoAdminDto toListadoDto(Animal animal, FichaAnimalCompleta ficha, ImagenAnimal imagen, String situacionCalculada);

    @AfterMapping
    protected void aplicarReglasPrevias(Animal animal, FichaAnimalCompleta ficha, ImagenAnimal imagen, String situacionCalculada, @MappingTarget AnimalesListadoAdminDto dto) {

        if (ficha != null) {

            String estadoStr = "Activo";
            if (ficha.getFechaFallec() != null) {
                estadoStr = "Fallecido";
            }
            dto.setEstado(estadoStr);
            dto.setUrgente(ficha.isUrgente());
        }

        if (animal != null) {

            LocalDate fechaNacimiento = animal.getFechaNacimiento();
            if (fechaNacimiento != null) {
                LocalDate fechaReferencia = LocalDate.now();
                if (ficha != null && ficha.getFechaFallec() != null) {
                    fechaReferencia = ficha.getFechaFallec();
                }
                if (!fechaReferencia.isBefore(fechaNacimiento)) {
                    long edad = ChronoUnit.YEARS.between(fechaNacimiento, fechaReferencia);
                    dto.setEdad((int) edad);
                }
            }
            if (animal.getRaza() != null && animal.getRaza().getEspecie() != null) {
                dto.setEspecie(animal.getRaza().getEspecie().getNombre());
            } else {
                dto.setEspecie("-");
            }
        }

        if (imagen != null) {
            dto.setArchivoUrl(imagen.getArchivoUrl());
            dto.setTextoAlt(imagen.getTextoAlt());
        }
    }
}