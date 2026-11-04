package com.protectora.tinkuy.services;

import com.protectora.tinkuy.entities.FichaAnimalCompleta;
import com.protectora.tinkuy.entities.Solicitud;
import com.protectora.tinkuy.entities.CandidaturaAnimal;

import java.util.List;

public interface SolicitudAnimalService {

    List<CandidaturaAnimal> obtenerPorAnimalId(Long animalId);

    Solicitud obtenerUltimaSolicitud(FichaAnimalCompleta ficha);

}
