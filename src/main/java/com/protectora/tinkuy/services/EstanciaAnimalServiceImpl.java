package com.protectora.tinkuy.services;

import com.protectora.tinkuy.entities.EstanciaAnimal;
import com.protectora.tinkuy.enumerations.TipoEstanciaEnum;
import com.protectora.tinkuy.repositories.EstanciaAnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class EstanciaAnimalServiceImpl implements EstanciaAnimalService {

    private final EstanciaAnimalRepository estanciaAnimalRepository;

    @Override
    public List<EstanciaAnimal> obtenerPorAnimalId(Long animalId) {

        List<EstanciaAnimal> resultado = new ArrayList<>();
        boolean idValido = (animalId != null);

        if (idValido) {

            List<EstanciaAnimal> estancias = estanciaAnimalRepository.findByAnimalId(animalId);
            boolean estanciasValidas = (estancias != null);
            if (estanciasValidas) {
                resultado.addAll(estancias);
            }
        }

        return resultado;
    }

    @Override
    public boolean estaAdoptado(Long animalId) {

        boolean adoptado = false;

        if (animalId != null) {
            adoptado = estanciaAnimalRepository.existsByAnimalIdAndTipoAndFechaFinIsNull(animalId, TipoEstanciaEnum.ADOPTANTE);
        }

        return adoptado;
    }

    @Override
    public boolean estaEnAcogida(Long animalId) {

        boolean enAcogida = false;

        if (animalId != null) {
            enAcogida = estanciaAnimalRepository.existsByAnimalIdAndTipoAndFechaFinIsNull(
                    animalId,
                    TipoEstanciaEnum.ACOGIDA
            );
        }

        return enAcogida;
    }
}