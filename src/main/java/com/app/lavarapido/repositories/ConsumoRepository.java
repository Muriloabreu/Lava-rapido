package com.app.lavarapido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.lavarapido.models.ConsumoModel;

@Repository
public interface ConsumoRepository extends JpaRepository<ConsumoModel, Long> {

}
