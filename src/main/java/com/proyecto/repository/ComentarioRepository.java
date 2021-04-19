package com.proyecto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.ComentarioVO;

@Repository
public interface ComentarioRepository extends CrudRepository<ComentarioVO, Integer>{
	
	List<ComentarioVO> findByPostIdpostOrderByFechacreacionDesc(int idpost);
	
	ComentarioVO findByIdcomentario(int idcomentario);

}
