package org.generation.blogPessoal.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table (name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@NotBlank(message = " O Nome é Obrigatório! ")
	@Size(min = 5, max = 100) 
	private String nome;
	
	@ApiModelProperty(example = "email@email.com.br")
	@NotBlank(message = " O Email é Obrigatório! ")
	@Size(min = 5, max = 100) 
	private String email;
	
	@NotBlank(message = " O Senha é Obrigatória! ")
	@Size(min = 5, max = 100) 
	private String senha;
	
	@Column(name = "tb_dataNascimento")
	@JsonFormat(pattern = "yyyy-mm-dd")
	private LocalDate dataNascimento;

	
	

	public Usuario(Long idUsuario, String nome,
			 String email, String senha, LocalDate dataNascimento) {
		
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
	}
	
	public Usuario() {
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
