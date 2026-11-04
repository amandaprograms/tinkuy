package com.protectora.tinkuy.services;

import com.protectora.tinkuy.entities.CustodiaAnimal;
import com.protectora.tinkuy.repositories.CustodiaAnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class CustodiaAnimalServiceImpl implements CustodiaAnimalService {

    private final CustodiaAnimalRepository custodiaAnimalRepository;

    @Override
    public List<CustodiaAnimal> obtenerPorAnimalId(Long animalId) {

        List<CustodiaAnimal> resultado = new ArrayList<>();
        boolean idValido = (animalId != null);

        if (idValido) {
            List<CustodiaAnimal> custodias = custodiaAnimalRepository.findByAnimalId(animalId);
            boolean custodiasValidas = (custodias != null);
            if (custodiasValidas) {
                resultado.addAll(custodias);
            }
        }

        return resultado;
    }
}