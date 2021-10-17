package org.generation.blogPessoal.Controller;

import java.util.List;

import org.generation.blogPessoal.Model.Postagem;
import org.generation.blogPessoal.Repositry.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repositorio;
	
	@GetMapping("/todos")
	public ResponseEntity<List<Postagem>> getAll(){
		return ResponseEntity.ok(repositorio.findAll());
	}
	@GetMapping("/{idPostagem}")
	public ResponseEntity<Postagem> GetById(@PathVariable Long idPostagem){
		return repositorio.findById(idPostagem)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repositorio.findAllByTituloContainingIgnoreCase(titulo));
	}
	@PostMapping("/salvar")
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(postagem));
	}
	@PutMapping("/atualizar")
	public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repositorio.save(postagem));
	}
	@DeleteMapping("/deletar/{idPostagem}")
	public void delete(@PathVariable Long idPostagem) {
		repositorio.deleteById(idPostagem);
	}

}
