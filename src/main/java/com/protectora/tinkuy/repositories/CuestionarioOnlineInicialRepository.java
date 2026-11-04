package com.protectora.tinkuy.repositories;

import com.protectora.tinkuy.entities.CuestionarioOnlineInicial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuestionarioOnlineInicialRepository extends JpaRepository <CuestionarioOnlineInicial, Long> {

}
