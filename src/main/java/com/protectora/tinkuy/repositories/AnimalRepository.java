package com.protectora.tinkuy.repositories;

import com.protectora.tinkuy.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

//    @Query("SELECT DISTINCT f.animal.id FROM FichaAnimalCompleta f WHERE f.animal IS NOT NULL AND f.animal.id IS NOT NULL")
//    List<Long> obtenerIdsAnimalesUnicos();
}
