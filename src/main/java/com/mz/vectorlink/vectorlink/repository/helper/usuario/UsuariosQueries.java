package com.mz.vectorlink.vectorlink.repository.helper.usuario;

import java.util.List;
import java.util.Optional;

import com.mz.vectorlink.vectorlink.model.Usuario;
import com.mz.vectorlink.vectorlink.repository.filter.UsuarioFilter;



public interface UsuariosQueries {

	public Optional<Usuario> porEmailEAtivo(String email);
	
	public List<String> permissoes(Usuario usuario);
	
	public List<Usuario> filtrar(UsuarioFilter filtro);
	
	public Usuario buscarComGrupos(Long codigo);
	
	
}
