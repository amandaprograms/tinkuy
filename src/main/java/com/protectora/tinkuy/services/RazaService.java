package com.protectora.tinkuy.services;

import com.protectora.tinkuy.entities.Raza;

import java.util.List;

public interface RazaService {

    List<Raza> obtenerTodos();

    Raza obtenerPorId(Long id);

    Raza agregar(Raza raza);

    Raza editar(Raza raza);

    void borrar(Long id);
}
