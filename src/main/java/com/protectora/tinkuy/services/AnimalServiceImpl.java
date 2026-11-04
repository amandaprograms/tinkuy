package com.protectora.tinkuy.services;

import com.protectora.tinkuy.entities.Animal;
import com.protectora.tinkuy.entities.ImagenAnimal;
import com.protectora.tinkuy.repositories.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;
    private final ImagenAnimalService imagenAnimalService;

    @Override
    public List<Animal> obtenerTodos() {
        return animalRepository.findAll();
    }

    @Override
    public Animal obtenerPorId(Long id) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new RuntimeException("No se ha encontrado el animal"));
        return animal;
    }

    @Override
    @Transactional
    public Animal agregar(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    @Transactional
    public Animal editar(Animal animal) {
        obtenerPorId(animal.getId());
        return animalRepository.save(animal);
    }

    @Override
    public List<ImagenAnimal> obtenerImagenesPorAnimalIds(List<Long> animalIds) {
        return imagenAnimalService.obtenerPorAnimalIds(animalIds);
    }

    @Override
    public List<ImagenAnimal> obtenerImagenesPrincipalesPorAnimalIds(List<Long> animalIds) {
        return imagenAnimalService.obtenerPrincipalesPorAnimalIds(animalIds);
    }

    @Override
    public List<ImagenAnimal> obtenerImagenesPorAnimalId(Long animalId) {
        return imagenAnimalService.obtenerPorAnimalId(animalId);
    }
}