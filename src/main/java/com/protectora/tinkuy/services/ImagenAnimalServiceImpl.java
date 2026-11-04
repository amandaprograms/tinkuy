package com.protectora.tinkuy.services;

import com.protectora.tinkuy.entities.ImagenAnimal;
import com.protectora.tinkuy.repositories.ImagenAnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ImagenAnimalServiceImpl implements ImagenAnimalService {

    private final ImagenAnimalRepository imagenAnimalRepository;

    @Override
    public List<ImagenAnimal> obtenerTodos() {
        return imagenAnimalRepository.findAll();
    }

    @Override
    public ImagenAnimal obtenerPorId(Long id) throws RuntimeException {

        return imagenAnimalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se ha encontrado la imagen del animal"));
    }

    @Override
    @Transactional
    public ImagenAnimal agregar(ImagenAnimal imagenAnimal) {

        return imagenAnimalRepository.save(imagenAnimal);
    }

    @Override
    @Transactional
    public ImagenAnimal editar(ImagenAnimal imagenAnimal) throws RuntimeException {

        obtenerPorId(imagenAnimal.getId());
        return imagenAnimalRepository.save(imagenAnimal);
    }

    @Override
    @Transactional
    public void borrar(Long id) throws RuntimeException {

        obtenerPorId(id);
        imagenAnimalRepository.deleteById(id);
    }


    @Override
    public List<ImagenAnimal> obtenerPorAnimalIds(List<Long> animalIds) {

        List<ImagenAnimal> resultado = new ArrayList<>();
        boolean idsValidos = (animalIds != null && !animalIds.isEmpty());

        if (idsValidos) {
            List<ImagenAnimal> imagenes = imagenAnimalRepository.findByAnimalIdInOrderByAnimalIdAscOrdenAsc(animalIds);
            boolean imagenesValidas = (imagenes != null);
            if (imagenesValidas) {
                resultado.addAll(imagenes);
            }
        }

        return resultado;
    }

    @Override
    public List<ImagenAnimal> obtenerPrincipalesPorAnimalIds(List<Long> animalIds) {

        List<ImagenAnimal> resultado = new ArrayList<>();
        boolean idsValidos = (animalIds != null && !animalIds.isEmpty());

        if (idsValidos) {
            List<ImagenAnimal> imagenes = imagenAnimalRepository.findImagenesPrincipalesPorAnimalIds(animalIds);
            boolean imagenesValidas = (imagenes != null);
            if (imagenesValidas) {
                resultado.addAll(imagenes);
            }
        }

        return resultado;
    }

    @Override
    public List<ImagenAnimal> obtenerPorAnimalId(Long animalId) {

        List<ImagenAnimal> resultado = new ArrayList<>();
        boolean idValido = (animalId != null);

        if (idValido) {
            List<ImagenAnimal> imagenes = imagenAnimalRepository.findByAnimalIdOrderByOrdenAsc(animalId);
            boolean imagenesValidas = (imagenes != null);
            if (imagenesValidas) {
                resultado.addAll(imagenes);
            }
        }

        return resultado;
    }
}