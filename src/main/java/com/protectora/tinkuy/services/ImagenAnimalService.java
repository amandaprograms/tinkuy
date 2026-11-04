package com.protectora.tinkuy.services;

import com.protectora.tinkuy.entities.ImagenAnimal;
import java.util.List;

public interface ImagenAnimalService {

    List<ImagenAnimal> obtenerTodos();

    ImagenAnimal obtenerPorId(Long id) throws RuntimeException;

    ImagenAnimal agregar(ImagenAnimal imagenAnimal);

    ImagenAnimal editar(ImagenAnimal imagenAnimal) throws RuntimeException;

    void borrar(Long id) throws RuntimeException;

    List<ImagenAnimal> obtenerPorAnimalIds(List<Long> animalIds);

    List<ImagenAnimal> obtenerPrincipalesPorAnimalIds(List<Long> animalIds);

    List<ImagenAnimal> obtenerPorAnimalId(Long animalId);
}