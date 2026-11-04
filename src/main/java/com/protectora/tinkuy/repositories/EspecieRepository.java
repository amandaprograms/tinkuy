package com.protectora.tinkuy.repositories;

import com.protectora.tinkuy.entities.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieRepository extends JpaRepository <Especie, Long> {

}
