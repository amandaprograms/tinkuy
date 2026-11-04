package com.protectora.tinkuy.repositories;

import com.protectora.tinkuy.entities.DetallesAnuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesAnuncioRepository extends JpaRepository <DetallesAnuncio, Long> {

}
