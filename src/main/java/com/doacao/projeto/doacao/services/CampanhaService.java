package com.doacao.projeto.doacao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.doacao.projeto.doacao.domain.Campanha;
import com.doacao.projeto.doacao.repositories.CampanhaRepository;
import com.doacao.projeto.doacao.services.exceptions.ObjectNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CampanhaService {

	@Autowired
	private CampanhaRepository repo;

	public Campanha buscar(Integer id) {
		Optional<Campanha> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Campanha.class.getName()));
	}

	public List<Campanha> listarTodos() {
		return repo.findAll();
	}

	public Campanha insert(Campanha obj) {
		return repo.save(obj);
	}

	public void delete(Integer id) {

		try {
			repo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {

			throw new ObjectNotFoundException("Objeto não excluido!");

		} catch (DataIntegrityViolationException e) {

			throw new ObjectNotFoundException(e.getMessage());
		}

	}

	public Campanha update(Integer id, Campanha obj) {
		try {
			Campanha entity = repo.getOne(id);
			updateData(entity, obj);
			return repo.save(entity);

		} catch (EntityNotFoundException e) {
			
			throw new ObjectNotFoundException("Não foi possivel atualizar o objeto!");

		}

	}

	private void updateData(Campanha entity, Campanha obj) {
		entity.setDataInicial(obj.getDataInicial());
		entity.setDataFinal(obj.getDataFinal());
		entity.setValor(obj.getValor());
		entity.setValorDaMeta(obj.getValorDaMeta());
		entity.setDescricao(obj.getDescricao());
		entity.setPessoas(obj.getPessoas());

	}

}
