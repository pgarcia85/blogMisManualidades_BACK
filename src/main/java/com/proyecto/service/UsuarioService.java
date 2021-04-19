package com.proyecto.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;




import com.proyecto.model.UsuarioVO;



public interface UsuarioService {
	
	UserDetails loadUsuarioByEmail(String email);
	
    Boolean existsByEmail(String email);
	
	Boolean existsByContrasena(String contrasena);
	
	Optional<UsuarioVO> findById(Long arg0) ;
	
	<S extends UsuarioVO> S save(S arg0);

	void deleteById(Long arg0);
}
