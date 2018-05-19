/**
 * 
 */
package com.mz.vectorlink.vectorlink.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mz.vectorlink.vectorlink.model.Usuario;
import com.mz.vectorlink.vectorlink.repository.Usuarios;



/**
 * @author XNhagumbe
 *
 */
@Service
public class AppUserDetailsService implements UserDetailsService{

	@Autowired
	private Usuarios usuarios;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    Optional<Usuario> usuarioOptional = usuarios.findByEmail(email);
	    
	    Usuario usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Usuáro e/ou senha incorrectos"));
		return new UsuarioSistema(usuario, getPermissoes(usuario));
	}

	private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		
		List<String> permissoes = usuarios.permissoes(usuario);
		permissoes.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.toUpperCase())));
		
		return authorities;
	}
	
}
