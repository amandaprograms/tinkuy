package com.protectora.tinkuy.repositories;

import com.protectora.tinkuy.entities.EstanciaAnimal;
import com.protectora.tinkuy.enumerations.TipoEstanciaEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstanciaAnimalRepository extends JpaRepository<EstanciaAnimal, Long> {

    List<EstanciaAnimal> findByAnimalId(Long animalId);

    boolean existsByAnimalIdAndTipoAndFechaFinIsNull(Long animalId, TipoEstanciaEnum tipo);

}
