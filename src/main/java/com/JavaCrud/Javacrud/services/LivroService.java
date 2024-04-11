package com.JavaCrud.Javacrud.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.biblioteca.models.Livro;
import com.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	public Optional<Livro> updateLivro(Long id, Livro livroUpd) {

		if (repository.findById(id).isPresent()) {
			return Optional.of(repository.save(livroUpd));
		}

		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado!", null);
	}
}
