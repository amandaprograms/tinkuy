package com.protectora.tinkuy.repositories;

import com.protectora.tinkuy.entities.DatosLegalesPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosLegalesPersonaRepository extends JpaRepository <DatosLegalesPersona, Long> {

}
