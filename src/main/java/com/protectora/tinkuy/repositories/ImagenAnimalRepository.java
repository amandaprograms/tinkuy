package com.protectora.tinkuy.repositories;

import com.protectora.tinkuy.entities.ImagenAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagenAnimalRepository extends JpaRepository<ImagenAnimal, Long> {

    List<ImagenAnimal> findByAnimalIdInOrderByAnimalIdAscOrdenAsc(List<Long> animalIds);

    @Query("SELECT i FROM ImagenAnimal i WHERE i.animal.id IN :animalIds AND i.orden = (SELECT MIN(i2.orden) FROM ImagenAnimal i2 WHERE i2.animal.id = i.animal.id) ORDER BY i.animal.id")
    List<ImagenAnimal> findImagenesPrincipalesPorAnimalIds(@Param("animalIds") List<Long> animalIds);

    List<ImagenAnimal> findByAnimalIdOrderByOrdenAsc(Long animalId);
}
