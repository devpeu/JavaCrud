package com.JavaCrud.Javacrud.models;

import java.util.Date;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdLivro;

	@NotBlank
	@Size(max = 100)
	private String titulo;

	@NotBlank
	@Size(max = 150)
	private String autor_principal;

	@jakarta.validation.constraints.NotNull
	private Integer ano_publicacao;

	@jakarta.validation.constraints.NotNull
	private Integer edicao;

	@jakarta.validation.constraints.NotNull
	@Temporal(TemporalType.DATE)
	private Date data_criacao;

	@Temporal(TemporalType.DATE)
	private Date data_alteracao;

	public Long getIdLivro() {
		return IdLivro;
	}

	public void setIdLivro(Long idLivro) {
		IdLivro = idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor_principal() {
		return autor_principal;
	}

	public void setAutor_principal(String autor_principal) {
		this.autor_principal = autor_principal;
	}

	public Integer getAno_publicacao() {
		return ano_publicacao;
	}

	public void setAno_publicacao(Integer ano_publicacao) {
		this.ano_publicacao = ano_publicacao;
	}

	public Integer getEdicao() {
		return edicao;
	}

	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}

	public Date getData_alteracao() {
		return data_alteracao;
	}

	public void setData_alteracao(Date data_alteracao) {
		this.data_alteracao = data_alteracao;
	}

}
