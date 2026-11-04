package com.protectora.tinkuy.services;

import com.protectora.tinkuy.entities.Raza;
import com.protectora.tinkuy.repositories.RazaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RazaServiceImpl implements  RazaService {

    private final RazaRepository razaRepository;

    @Override
    public List<Raza> obtenerTodos() {

        return razaRepository.findAll();
    }

    @Override
    public Raza obtenerPorId(Long id) throws RuntimeException {

        return razaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se ha encontrado la raza"));
    }

    @Override
    public Raza agregar(Raza raza) {

        return razaRepository.save(raza);
    }

    @Override
    public Raza editar(Raza raza) throws RuntimeException {

        obtenerPorId(raza.getId());
        return razaRepository.save(raza);
    }

    @Override
    public void borrar(Long id) throws RuntimeException {

        obtenerPorId(id);
        razaRepository.deleteById(id);
    }

}
