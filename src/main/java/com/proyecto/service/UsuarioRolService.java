package com.proyecto.service;

import java.util.Optional;

import com.proyecto.model.UsuarioRolVO;

public interface UsuarioRolService {
	
	<S extends UsuarioRolVO> S save(S arg0);
	
	void deleteById(Integer arg0);
	
	Iterable<UsuarioRolVO> findAll();
	
	Iterable<UsuarioRolVO> findByUsuarioIdusuario(Long idUsuario);
	
	Optional<UsuarioRolVO> findByUsuarioIdusuarioAndRolIdrol(Long idUsuario, Long idrol);

}
