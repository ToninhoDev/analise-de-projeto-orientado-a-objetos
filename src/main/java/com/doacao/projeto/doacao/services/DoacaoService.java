package com.doacao.projeto.doacao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.doacao.projeto.doacao.domain.Doacao;
import com.doacao.projeto.doacao.repositories.DoacaoRepository;
import com.doacao.projeto.doacao.services.exceptions.ObjectNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DoacaoService {

	@Autowired
	private DoacaoRepository repo;

	public Doacao buscar(Integer id) {
		Optional<Doacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Doacao.class.getName()));
	}

	public List<Doacao> listarTodos() {
		return repo.findAll();
	}

	public Doacao insert(Doacao obj) {

		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			repo.deleteById(id);
			
		}catch(EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Objeto não excluido!");
		}catch(DataIntegrityViolationException e) {
			throw new ObjectNotFoundException(e.getMessage());
		}
	}
	
	public Doacao update(Integer id, Doacao obj) {
		try {
			Doacao entity = repo.getOne(id);
			updateDoacao(entity, obj);
			return repo.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ObjectNotFoundException("Impossilvel atualizar");
		}
	}
	
	
	
	public void updateDoacao(Doacao entity, Doacao obj) {
		entity.setBeneficiario(obj.getBeneficiario());
		entity.setFormaDePagamento(obj.getFormaDePagamento());
		entity.setValor(obj.getValor());
	}

}
