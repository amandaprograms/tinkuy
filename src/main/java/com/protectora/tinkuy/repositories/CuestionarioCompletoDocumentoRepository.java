package com.protectora.tinkuy.repositories;

import com.protectora.tinkuy.entities.CuestionarioCompletoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuestionarioCompletoDocumentoRepository extends JpaRepository <CuestionarioCompletoDocumento, Long> {

}
