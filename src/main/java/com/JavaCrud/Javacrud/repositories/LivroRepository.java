package com.JavaCrud.Javacrud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	public List<Livro> findAllByTituloContainingIgnoreCase(String titulo);
}