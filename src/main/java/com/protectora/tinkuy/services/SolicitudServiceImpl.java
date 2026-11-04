package com.protectora.tinkuy.services;

import com.protectora.tinkuy.entities.FichaAnimalCompleta;
import com.protectora.tinkuy.entities.Raza;
import com.protectora.tinkuy.entities.Solicitud;
import com.protectora.tinkuy.repositories.RazaRepository;
import com.protectora.tinkuy.repositories.SolicitudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SolicitudServiceImpl implements  SolicitudService {

    private final SolicitudRepository solicitudRepository;

}
