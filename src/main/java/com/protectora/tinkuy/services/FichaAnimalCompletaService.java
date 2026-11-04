package com.protectora.tinkuy.services;

import com.protectora.tinkuy.entities.FichaAnimalCompleta;
import com.protectora.tinkuy.enumerations.CategoriaEdadEnum;
import com.protectora.tinkuy.enumerations.SexoAnimalEnum;
import com.protectora.tinkuy.enumerations.TamanoAnimalEnum;
import com.protectora.tinkuy.models.AnimalesFiltrosAdmin;

import java.util.List;

public interface FichaAnimalCompletaService {

    List<FichaAnimalCompleta> obtenerTodos();

    FichaAnimalCompleta obtenerPorId(Long id) throws RuntimeException;

    FichaAnimalCompleta agregar(FichaAnimalCompleta fichaAnimalCompleta);

    FichaAnimalCompleta editar(FichaAnimalCompleta fichaAnimalCompleta);

    void borrar(Long id) throws RuntimeException;

    List<FichaAnimalCompleta> obtenerAnimalesConFicha();

    List<FichaAnimalCompleta> obtenerResultFiltros(AnimalesFiltrosAdmin filtros);

    String obtenerSituacionAnimal(FichaAnimalCompleta ficha);

    boolean estaAdoptado(Long animalId);

    Long obtenerTotalAnimales();

    Long obtenerTotalUrgentes();

    Long obtenerTotalEnAdopcion();

    Long obtenerTotalAdoptados();

}