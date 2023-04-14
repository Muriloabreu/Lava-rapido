package com.app.lavarapido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.lavarapido.models.ServicoModel;

@Repository
public interface ServicoRepository extends JpaRepository<ServicoModel,Long> {

}
