package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.model.UsuarioPostFavoritoVO;

public interface UsuarioPostFavoritoService {
	
	<S extends UsuarioPostFavoritoVO> S save(S arg0);
	
	 List<UsuarioPostFavoritoVO> findAllByUsuarioFavIdusuario(Long idUsuario);
	 
	 void deleteById(Integer arg0);
	 
	 Optional<UsuarioPostFavoritoVO> findById(Integer arg0);
	 
	 long deleteByUsuarioFavIdUsuarioPostFavIdpost(Long idUsuario, Integer idPost);
}
