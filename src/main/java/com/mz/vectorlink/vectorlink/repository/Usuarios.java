/**
 * 
 */
package com.mz.vectorlink.vectorlink.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mz.vectorlink.vectorlink.model.Usuario;
import com.mz.vectorlink.vectorlink.repository.helper.usuario.UsuariosQueries;

/**
 * @author XNhagumbe
 *
 */
@Repository
public interface Usuarios extends JpaRepository<Usuario, Long>, UsuariosQueries {

	public Optional<Usuario> findByEmail(String email);
	
	public List<Usuario> findByCodigoIn(Long[] codigos);

	
	

}
