package com.doacao.projeto.doacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doacao.projeto.doacao.domain.Doador;

@Repository
public interface DoadorRepository extends JpaRepository<Doador, Integer> {

}
