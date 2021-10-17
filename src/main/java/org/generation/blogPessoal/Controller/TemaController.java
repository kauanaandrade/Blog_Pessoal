package org.generation.blogPessoal.Controller;

import java.util.List;

import org.generation.blogPessoal.Model.Tema;
import org.generation.blogPessoal.Repositry.TemaRepository;
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
@RequestMapping("/api/v1/tema")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {

	@Autowired
	private TemaRepository repositorio;

	@GetMapping("/todas")
	public ResponseEntity<List<Tema>> getAll() {
		return ResponseEntity.ok(repositorio.findAll());
	}

	@GetMapping("/{idTema}")
	public ResponseEntity<Tema> getByTd(@PathVariable Long idTema) {
		return repositorio.findById(idTema).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Tema>> getByName(@PathVariable String nome) {
		return ResponseEntity.ok(repositorio.findAllByDescricaoContainingIgnoreCase(nome));
	}

	@PostMapping("/salvar")
	public ResponseEntity<Tema> post(@RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repositorio.save(tema));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Tema> put(@RequestBody Tema tema) {
		return ResponseEntity.ok(repositorio.save(tema));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long idTema) {
		repositorio.deleteById(idTema);

	}

}
