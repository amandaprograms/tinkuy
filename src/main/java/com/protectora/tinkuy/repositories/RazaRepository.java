package com.protectora.tinkuy.repositories;

import com.protectora.tinkuy.entities.Raza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RazaRepository extends JpaRepository <Raza, Long> {

}
