package com.doacao.projeto.doacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doacao.projeto.doacao.domain.Campanha;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Integer> {

}
