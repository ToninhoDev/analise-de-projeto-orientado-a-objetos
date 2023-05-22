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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.doacao.projeto.doacao.domain.Doador;
import com.doacao.projeto.doacao.services.DoadorService;

@RestController
@RequestMapping(value = "/doadores")
public class DoadorResouce {

	@Autowired
	private DoadorService service;

	@GetMapping
	public ResponseEntity<List<Doador>> findAll() {
		List<Doador> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<Doador> findById(@PathVariable Integer id) {
		Doador obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}
	@PostMapping
	public ResponseEntity<Doador> insert(@RequestBody Doador obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Doador> update(@PathVariable Integer id, @RequestBody Doador obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}

}
