package org.generation.blogPessoal.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.generation.blogPessoal.Model.UserLogin;
import org.generation.blogPessoal.Model.Usuario;
import org.generation.blogPessoal.Repositry.UsuarioRepository;
import org.generation.blogPessoal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping("/logar")
	public ResponseEntity<UserLogin> Autentication(@Valid @RequestBody Optional<UserLogin> user){
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	@PostMapping("/cadastrar")
    public ResponseEntity<Object> salvar(@Valid @RequestBody Usuario usuario) {
        return usuarioService.CadastrarUsuario(usuario).map(resp -> ResponseEntity.status(201).body(resp))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                            "Email existente, cadastre outro email!.");
                });

    }
	@GetMapping("/todos")
    public ResponseEntity<List<Usuario>> getAll(){
        if(repository.findAll().isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        else {
            return ResponseEntity.status(200).body(repository.findAll());
        }
    }


}
