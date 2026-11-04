package com.protectora.tinkuy.repositories;

import com.protectora.tinkuy.entities.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {


}
