package org.generation.blogPessoal.seguranca;

import java.util.Optional;

import org.generation.blogPessoal.Model.Usuario;
import org.generation.blogPessoal.Repositry.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> user = userRepository.findByEmail(email);
		user.orElseThrow(() -> new UsernameNotFoundException(email + "not found."));
		return user.map(UserDatilsImpl :: new).get();
	}
		
	
}
