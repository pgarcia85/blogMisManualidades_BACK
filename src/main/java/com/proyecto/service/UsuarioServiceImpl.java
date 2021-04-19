package com.proyecto.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.proyecto.model.UsuarioVO;
import com.proyecto.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Override
	@Transactional
	public UserDetails loadUsuarioByEmail(String email) {
		UsuarioVO usuario = usuarioRepository.findByEmail(email).get();
		return UserDetailsImpl.build(usuario);
	}

	@Override
	public Boolean existsByEmail(String email) {		
		return usuarioRepository.existsByEmail(email);
	}


	@Override
	public Boolean existsByContrasena(String contrasena) {	
		return usuarioRepository.existsByContrasena(contrasena);
	}


	@Override
	public Optional<UsuarioVO> findById(Long arg0) {		
		return usuarioRepository.findById(arg0);
	}


	@Override
	public <S extends UsuarioVO> S save(S arg0) {		
		return usuarioRepository.save(arg0);
	}

	@Override
	public void deleteById(Long arg0) {
		usuarioRepository.deleteById(arg0);
	}



}
