package com.proyecto.service;

import java.util.List;



import java.util.Optional;

import com.proyecto.model.ComentarioVO;

public interface ComentarioService {
	
	List<ComentarioVO> findByIdpost(int idpost);
	
	<S extends ComentarioVO> S save(S arg0);
	
	void deleteById(Integer arg0);
	 
	Optional<ComentarioVO> findById(Integer arg0);

}
