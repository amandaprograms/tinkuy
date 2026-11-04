package com.protectora.tinkuy.services;

import com.protectora.tinkuy.entities.EstanciaAnimal;

import java.util.List;

public interface EstanciaAnimalService {

    List<EstanciaAnimal> obtenerPorAnimalId(Long animalId);

    boolean estaAdoptado(Long animalId);

    boolean estaEnAcogida(Long animalId);
}
