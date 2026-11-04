package com.protectora.tinkuy.services;

import com.protectora.tinkuy.entities.CustodiaAnimal;

import java.util.List;

public interface CustodiaAnimalService {

    List<CustodiaAnimal> obtenerPorAnimalId(Long animalId);
}
