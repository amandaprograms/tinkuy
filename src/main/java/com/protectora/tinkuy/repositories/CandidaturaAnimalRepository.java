package com.protectora.tinkuy.repositories;

import com.protectora.tinkuy.entities.CandidaturaAnimal;
import com.protectora.tinkuy.entities.CandidaturaAnimalId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidaturaAnimalRepository extends JpaRepository<CandidaturaAnimal, CandidaturaAnimalId> {

    List<CandidaturaAnimal> findByAnimalId(Long animalId);

    List<CandidaturaAnimal> findByAnimalIdOrderBySolicitudIdDesc(Long animalId);

//    List<CandidaturaAnimal> findFirstByAnimalIdOrderBySolicitudIdDesc(Long animalId);

    Optional<CandidaturaAnimal> findFirstByAnimalIdOrderBySolicitudIdDesc(Long animalId);
}
