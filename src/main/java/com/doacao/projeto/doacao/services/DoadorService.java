package com.doacao.projeto.doacao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.doacao.projeto.doacao.domain.Doador;
import com.doacao.projeto.doacao.repositories.DoadorRepository;
import com.doacao.projeto.doacao.services.exceptions.ObjectNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DoadorService {
	
	@Autowired
	public DoadorRepository repo;
	
	public List<Doador> findAll(){
		return repo.findAll();
	}
	
	public Doador findById(Integer id) {
		Optional<Doador> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Doador.class.getName()));
	}
	
	public Doador insert(Doador obj) {
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
	
	public Doador update(Integer id, Doador obj) {
		try {
			Doador entity = repo.getOne(id);
			updateDoador(entity, obj);
			return repo.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ObjectNotFoundException("Objeto não atualizado!");
		}
	}
	
	
	
	public void updateDoador(Doador entity, Doador obj) {
		entity.setNome(obj.getNome());
		entity.setDataCadastro(obj.getDataCadastro());
		entity.setSituacao(obj.getSituacao());
		entity.setEndereco(obj.getEndereco());
		entity.setTelefone(obj.getTelefone());
		entity.setDocumento(obj.getDocumento());
	}

}
