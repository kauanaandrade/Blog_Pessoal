package org.generation.blogPessoal.Model;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagem")


public class Postagem {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idPostagem;
	private @NotBlank String titulo;
	private @NotBlank String descricao;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataPostagem = LocalDate.now();

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	public Long getIdPostagem() {
		return idPostagem;
	}

	public void setIdPostagem(Long idPostagem) {
		this.idPostagem = idPostagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	
	
	
	

}