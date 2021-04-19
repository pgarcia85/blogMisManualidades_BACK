package com.proyecto.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.model.UsuarioRolVO;

public interface UsuarioRolRepository extends CrudRepository<UsuarioRolVO, Integer>{
	
	Iterable<UsuarioRolVO> findByUsuarioIdusuario(Long idUsuario);
	
	Optional<UsuarioRolVO> findByUsuarioIdusuarioAndRolIdrol(Long idUsuario, Long idRol);

}
