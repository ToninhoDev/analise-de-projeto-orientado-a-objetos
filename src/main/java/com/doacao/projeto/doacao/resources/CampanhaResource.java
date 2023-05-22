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

import com.doacao.projeto.doacao.domain.Campanha;
import com.doacao.projeto.doacao.services.CampanhaService;

@RestController
@RequestMapping(value = "/campanhas")
public class CampanhaResource {

	@Autowired
	private CampanhaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Campanha obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);

	}

	@GetMapping
	public ResponseEntity<List<Campanha>> findAll() {
		List<Campanha> list = service.listarTodos();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Campanha> insert(@RequestBody Campanha obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Campanha> update(@PathVariable Integer id, @RequestBody Campanha obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}

}
