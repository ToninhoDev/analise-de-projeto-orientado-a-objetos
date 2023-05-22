package com.doacao.projeto.doacao.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.doacao.projeto.doacao.domain.Doacao;
import com.doacao.projeto.doacao.services.DoacaoService;

@RestController
@RequestMapping(value = "/doacoes")
public class DoacaoResource {

	@Autowired
	private DoacaoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Doacao obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);

	}
	
	@GetMapping
	public ResponseEntity<List<Doacao>> findAll(){
		List<Doacao> list = service.listarTodos();
		return ResponseEntity.ok().body(list);
	}
	@PostMapping
	public ResponseEntity<Doacao> insert(@RequestBody Doacao obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<Doacao> update(@PathVariable Integer id, @RequestBody Doacao obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
 
}
