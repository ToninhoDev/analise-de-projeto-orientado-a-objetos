package com.doacao.projeto.doacao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.doacao.projeto.doacao.domain.Ong;
import com.doacao.projeto.doacao.repositories.OngRepository;
import com.doacao.projeto.doacao.services.exceptions.ObjectNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OngService {

	@Autowired
	private OngRepository repo;

	public Ong buscar(Integer id) {
		Optional<Ong> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Ong.class.getName()));
	}

	public List<Ong> findAll() {
		return repo.findAll();
	}

	public Ong insert(Ong obj) {
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
	
	public Ong update(Integer id, Ong obj) {
		try {
			Ong entity = repo.getOne(id);
			updateOng(entity, obj);
			return repo.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ObjectNotFoundException("Objeto não atualizado");
		}
	}
	
	
	private void updateOng(Ong entity, Ong obj) {
		entity.setNome(obj.getNome());
		entity.setCnpj(obj.getCnpj());
		entity.setConta(obj.getConta());
		entity.setTelefone(obj.getTelefone());
		entity.setStatus(obj.getStatus());
	}

}
