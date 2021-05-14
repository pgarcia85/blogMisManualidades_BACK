package com.proyecto.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;






import com.proyecto.model.UsuarioVO;



public interface UsuarioService {
	/**
	 * Construye un usuarios buscandolo a partir de su email
	 * @param email
	 * @return
	 */
	UserDetails loadUsuarioByEmail(String email);
	
	/**
	 * Comprueba si ya existe un email
	 * @param email
	 * @return
	 */
    Boolean existsByEmail(String email);
    
	/**
	 * Comprueba si ya existe una contraseña
	 * @param contrasena
	 * @return
	 */
	Boolean existsByContrasena(String contrasena);
	
	/**
	 * Busca un usuario por su id
	 * @param arg0
	 * @return
	 */
	Optional<UsuarioVO> findById(Long arg0) ;
	
	/**
	 * Guarda un usuario
	 * @param arg0
	 * @return
	 */
	<S extends UsuarioVO> S save(S arg0);

	/**
	 * Elimina un usuario
	 * 
	 * @param arg0
	 */
	void deleteById(Long arg0);
	
	/**
	 * Devuelve todos los usuarios
	 * 
	 * @return
	 */
	Iterable<UsuarioVO> findAll();
	
	/**
	 * Devuelve todos los usuarios con un rol determinado
	 * @param idRol
	 * @return
	 */
	Iterable<UsuarioVO> findByRolesRolIdrol(Long idRol);
	
	
}
