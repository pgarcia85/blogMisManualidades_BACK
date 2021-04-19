package com.proyecto.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;



import com.proyecto.model.UsuarioVO;

public interface UsuarioRepository extends CrudRepository<UsuarioVO, Long>{

	Optional <UsuarioVO> findByEmail(String email);
	
	Boolean existsByEmail(String email);
	
	Boolean existsByContrasena(String contrasena);
	
}
