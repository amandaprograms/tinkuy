package com.protectora.tinkuy.repositories;

import com.protectora.tinkuy.entities.FichaAnimalCompleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FichaAnimalCompletaRepository extends JpaRepository<FichaAnimalCompleta, Long> {

    @Query("SELECT f FROM FichaAnimalCompleta f JOIN FETCH f.animal")
    List<FichaAnimalCompleta> findAnimalesConFicha();

    long countByUrgenteTrue();

    @Query(value = "SELECT COUNT(DISTINCT e.animal_id) FROM estancia_animal e INNER JOIN ficha_animal_completa f ON f.animal_id = e.animal_id WHERE e.tipo = 'ADOPTANTE' AND e.fecha_fin IS NULL AND f.fecha_fallec IS NULL", nativeQuery = true)
    Long contarAnimalesAdoptados();

    @Query("SELECT DISTINCT f.animal.id FROM FichaAnimalCompleta f")
    List<Long> obtenerIdsAnimalesUnicos();

}

