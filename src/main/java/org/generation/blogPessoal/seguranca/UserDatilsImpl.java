package org.generation.blogPessoal.seguranca;

import java.util.Collection;
import java.util.List;

import org.generation.blogPessoal.Model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDatilsImpl implements UserDetails {
	
	/**
	 * 
	 */
	private static final Long serialVersionUID = 1L;
	private String email;
	private String password;
	
	private List<GrantedAuthority> autorizacoes;

	
	public UserDatilsImpl(Usuario user) {
		this.email = user.getEmail();
		this.password = user.getSenha();
		}
	
	public UserDatilsImpl() {}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return autorizacoes;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public static Long getSerialversionuid() {
		return serialVersionUID;
	}

}
