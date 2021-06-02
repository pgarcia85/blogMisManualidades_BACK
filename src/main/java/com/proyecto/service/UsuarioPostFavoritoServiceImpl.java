package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.UsuarioPostFavoritoVO;
import com.proyecto.repository.UsuarioPostRepository;

@Service
public class UsuarioPostFavoritoServiceImpl implements UsuarioPostFavoritoService{
	
	@Autowired
	private UsuarioPostRepository usuarioPostRepository;

	@Override
	public <S extends UsuarioPostFavoritoVO> S save(S arg0) {
		return usuarioPostRepository.save(arg0);
	}

	@Override
	public List<UsuarioPostFavoritoVO> findAllByUsuarioFavIdusuario(Long idUsuario) {
		return usuarioPostRepository.findAllByUsuarioFavIdusuarioOrderByPostFavFechacreacionDesc(idUsuario);
	}

	@Override
	public void deleteById(Integer arg0) {
		usuarioPostRepository.deleteById(arg0);
	}
	
	@Override
	public Optional<UsuarioPostFavoritoVO> findById(Integer arg0) {		
		return usuarioPostRepository.findById(arg0);
	}

	@Override
	public long deleteByUsuarioFavIdUsuarioPostFavIdpost(Long idUsuario,
			Integer idPost) {
	return usuarioPostRepository.deleteByUsuarioFavIdusuarioAndPostFavIdpost(idUsuario, idPost);
		
	}
	
	
	

}
