package org.generation.blogPessoal.Repositry;



import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.Model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

	//public Optional<Usuario> findByUsuario(String usuario);
	 
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

	    public Usuario findByNome(String nome);

	    public Optional<Usuario> findByEmail(String email);

		//public Object findByUsuario(Long idUsuario);
}

/*	@BeforeAll
	void start() {

		LocalDate data = LocalDate.parse("2003-01-13", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Usuario usuario = new Usuario(0L, "Kauana Andrade", "kauana@gmail.com", "12345678", data);

		if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
			usuarioRepository.save(usuario);

		 usuario = new Usuario(0L, "Irlene Andrade", "irlene@gmail.com", "12345678", data);

		 if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
				usuarioRepository.save(usuario);
		

		usuario = new Usuario(0L, "Yasmin Andrade", "yasmin@gmail.com", "12345678", data);

		if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
			usuarioRepository.save(usuario);

		usuario = new Usuario(0L, "Marcio Vitor", "marciovitor@gmail.com", "12345678", data);

		if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
			usuarioRepository.save(usuario);
	}*/