package com.JavaCrud.Javacrud.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.models.Livro;
import com.biblioteca.repositories.LivroRepository;
import com.biblioteca.services.LivroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/biblioteca")
public class LivroController {

	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private LivroService service;
	
	@GetMapping("/livros")
	public ResponseEntity<List<Livro>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/livro/{idLivro}")
	public ResponseEntity<Livro> getById(@PathVariable Long idLivro){
		return repository.findById(idLivro)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/livro")
	public ResponseEntity<List<Livro>> getByTitle(@RequestParam(name = "titulo") String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping ("/livro")
	public ResponseEntity<Livro> post(@Valid @RequestBody Livro livro){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(livro));
	}
	
	@PutMapping("/livro/{idLivro}")
	public ResponseEntity<Livro> update(@PathVariable Long idLivro, @RequestBody Livro livro){
		return service.updateLivro(idLivro, livro)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/livro/{idLivro}")
	public void delete(@PathVariable Long idLivro) {
		repository.deleteById(idLivro);
	}
}
