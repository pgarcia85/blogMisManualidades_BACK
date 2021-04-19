package com.proyecto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.RolVO;
import com.proyecto.model.UsuarioRolVO;
import com.proyecto.repository.UsuarioRolRepository;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {

	@Autowired
	private UsuarioRolRepository usuarioRolRepository;


	@Override
	public <S extends UsuarioRolVO> S save(S arg0) {
		return usuarioRolRepository.save(arg0);
	}


	@Override
	public void deleteById(Integer arg0) {
		usuarioRolRepository.deleteById(arg0);
	}


	@Override
	public Iterable<UsuarioRolVO> findAll() {
		return usuarioRolRepository.findAll();
	}

	@Override
	public Iterable<UsuarioRolVO> findByUsuarioIdusuario(Long idUsuario) {
		return usuarioRolRepository.findByUsuarioIdusuario(idUsuario);
	}

	@Override
	public Optional<UsuarioRolVO> findByUsuarioIdusuarioAndRolIdrol(Long idUsuario, Long idrol) {
		return usuarioRolRepository
				.findByUsuarioIdusuarioAndRolIdrol(idUsuario, idrol);
	}
	
	
	

}
