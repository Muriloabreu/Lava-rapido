package com.app.lavarapido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.lavarapido.models.TipoServicoModel;

@Repository
public interface TipoServicoRepository extends JpaRepository<TipoServicoModel, Long> {

}
