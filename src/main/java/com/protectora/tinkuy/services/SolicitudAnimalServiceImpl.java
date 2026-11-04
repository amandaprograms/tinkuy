package com.protectora.tinkuy.services;

import com.protectora.tinkuy.entities.CandidaturaAnimal;
import com.protectora.tinkuy.entities.FichaAnimalCompleta;
import com.protectora.tinkuy.entities.Solicitud;
import com.protectora.tinkuy.repositories.CandidaturaAnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class SolicitudAnimalServiceImpl implements SolicitudAnimalService {

    private final CandidaturaAnimalRepository candidaturaAnimalRepository;

    @Override
    public List<CandidaturaAnimal> obtenerPorAnimalId(Long animalId) {

        List<CandidaturaAnimal> resultado = new ArrayList<>();
        boolean idValido = (animalId != null);

        if (idValido) {

            List<CandidaturaAnimal> solicitudesAnimal = candidaturaAnimalRepository.findByAnimalId(animalId);
            boolean solicitudesValidas = (solicitudesAnimal != null);

            if (solicitudesValidas) {
                resultado.addAll(solicitudesAnimal);
            }
        }

        return resultado;
    }

    public Solicitud obtenerUltimaSolicitud(FichaAnimalCompleta ficha) {

        Solicitud ultimaSolicitud = null;

        boolean fichaValida = (ficha != null && ficha.getAnimal() != null && ficha.getAnimal().getId() != null);

        if (fichaValida) {
            Long animalId = ficha.getAnimal().getId();

            List<CandidaturaAnimal> relacionSolicitudes = candidaturaAnimalRepository.findByAnimalIdOrderBySolicitudIdDesc(animalId);

            boolean relacionValida = (relacionSolicitudes != null && !relacionSolicitudes.isEmpty());
            if (relacionValida) {
                CandidaturaAnimal ultimaRelacion = relacionSolicitudes.get(0);
                if (ultimaRelacion != null) {
                    ultimaSolicitud = ultimaRelacion.getSolicitud();
                }
            }
        }

        return ultimaSolicitud;
    }
}