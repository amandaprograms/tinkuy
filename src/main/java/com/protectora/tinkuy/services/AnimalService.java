package com.protectora.tinkuy.services;

import com.protectora.tinkuy.entities.Animal;
import com.protectora.tinkuy.entities.ImagenAnimal;

import java.util.List;

public interface AnimalService {

    List<Animal> obtenerTodos();

    Animal obtenerPorId(Long id);

    Animal agregar(Animal animal);

    Animal editar(Animal animal);

    List<ImagenAnimal> obtenerImagenesPorAnimalIds(List<Long> animalIds);

    List<ImagenAnimal> obtenerImagenesPrincipalesPorAnimalIds(List<Long> animalIds);

    List<ImagenAnimal> obtenerImagenesPorAnimalId(Long animalId);
}