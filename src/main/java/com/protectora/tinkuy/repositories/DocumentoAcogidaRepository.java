package com.protectora.tinkuy.repositories;

import com.protectora.tinkuy.entities.DocumentoAcogida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoAcogidaRepository extends JpaRepository <DocumentoAcogida, Long> {

}
