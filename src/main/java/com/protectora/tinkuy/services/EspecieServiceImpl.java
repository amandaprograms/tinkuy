package com.protectora.tinkuy.services;

import com.protectora.tinkuy.entities.Especie;
import com.protectora.tinkuy.repositories.EspecieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EspecieServiceImpl implements EspecieService {

    private final EspecieRepository especieRepository;

    @Override
    public List<Especie> obtenerTodos() {

        return especieRepository.findAll();
    }

    @Override
    public Especie obtenerPorId(Long id) throws RuntimeException {

        return especieRepository.findById(id).orElseThrow(() -> new RuntimeException("No se ha encontrado la especie"));
    }

    @Override
    public Especie agregar(Especie especie) {

        return especieRepository.save(especie);
    }

    @Override
    public Especie editar(Especie especie) throws RuntimeException {

        obtenerPorId(especie.getId());
        return especieRepository.save(especie);
    }

    @Override
    public void borrar(Long id) throws RuntimeException {

        obtenerPorId(id);
        especieRepository.deleteById(id);
    }

}
