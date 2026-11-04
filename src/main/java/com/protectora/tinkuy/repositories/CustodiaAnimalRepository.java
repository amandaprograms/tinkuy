package com.protectora.tinkuy.repositories;

import com.protectora.tinkuy.entities.CustodiaAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustodiaAnimalRepository extends JpaRepository<CustodiaAnimal, Long> {

    List<CustodiaAnimal> findByAnimalId(Long animalId);
}
