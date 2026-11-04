package com.protectora.tinkuy.services;

import com.protectora.tinkuy.entities.Especie;

import java.util.List;

public interface EspecieService {

    List<Especie> obtenerTodos();

    Especie obtenerPorId(Long id);

    Especie agregar(Especie especie);

    Especie editar(Especie especie);

    void borrar(Long id);
}
