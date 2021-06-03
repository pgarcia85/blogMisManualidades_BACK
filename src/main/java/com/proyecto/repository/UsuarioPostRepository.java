package com.proyecto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.model.UsuarioPostFavoritoVO;

@Repository
public interface UsuarioPostRepository extends CrudRepository<UsuarioPostFavoritoVO, Integer>{
	
	List<UsuarioPostFavoritoVO> findAllByUsuarioFavIdusuarioOrderByPostFavFechacreacionDesc(Long idUsuario);
	
	@Transactional
	long deleteByUsuarioFavIdusuarioAndPostFavIdpost(Long idUsuario, Integer idPost);

}
