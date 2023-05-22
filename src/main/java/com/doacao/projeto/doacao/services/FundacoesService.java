package com.doacao.projeto.doacao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.doacao.projeto.doacao.domain.Fundacoes;
import com.doacao.projeto.doacao.domain.Ong;
import com.doacao.projeto.doacao.repositories.FundacoesRepository;
import com.doacao.projeto.doacao.services.exceptions.ObjectNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FundacoesService {

	@Autowired
	private FundacoesRepository repo;

	public Fundacoes buscar(Integer id) {
		Optional<Fundacoes> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Ong.class.getName()));
	}

	public List<Fundacoes> findAll() {
		return repo.findAll();
	}

	public Fundacoes insert(Fundacoes obj) {
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
	
	public Fundacoes update(Integer id, Fundacoes obj) {
		try {
			Fundacoes entity = repo.getOne(id);
			updateOng(entity, obj);
			return repo.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ObjectNotFoundException("Objeto não atualizado");
		}
	}
	
	
	private void updateOng(Fundacoes entity, Fundacoes obj) {
		entity.setNome(obj.getNome());
		entity.setCnpj(obj.getCnpj());
		entity.setTelefone(obj.getTelefone());
		entity.setEndereco(obj.getEndereco());
	}

}
